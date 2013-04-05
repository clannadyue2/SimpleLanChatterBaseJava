package org.clannadyue.chat.core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户管理器，负责管理用户的状态，采用单例模式
 */
public class UserManager {

    private static UserManager userManager = new UserManager();
    private ConfigureManager configMana;
    private Set<User> users;

    public static UserManager getInstance() {
        return userManager;
    }

    public UserManager() {
        //users = new HashSet<User>();
        users = Collections.synchronizedSet(new HashSet<User>());
    }

    /**
     * 初始化监听用户状态服务，在系统初始化时调用
     */
    public void initListener() {
        configMana = ConfigureManager.getInstance();
        runListenUsers();
    }

    private void runListenUsers() {
        InetAddress ip = (InetAddress) configMana.getConfigs().get(Globle.MULTI_CAST_ADDR);
        User user = (User) configMana.getConfigs().get(Globle.USER);
        try {
            new Thread(new MulticastClient(user, ip)).start();
            new Thread(new MulticastServer(ip)).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得用户管理器维护的用户的状态信息
     */
    public Set<User> getUserInfo() {
        return users;
    }

    public String getUserNameByIp(InetAddress ip) {
        for (User user : users) {
            if (user.getLoginIp().equals(ip)) {
                return user.getName();
            }
        }
        return null;
    }

    public InetAddress getIpByUserName(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user.getLoginIp();
            }
        }
        return null;
    }

    private class MulticastServer implements Runnable {

        private InetAddress multicastAddr;
        private MulticastSocket client;

        public MulticastServer(InetAddress ip) {
            this.multicastAddr = ip;
            try {
                client = new MulticastSocket(Globle.MULTI_CAST_PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                client.joinGroup(this.multicastAddr);
                while (true) {
                    freshUserInfo();
                    checkNotOnlineUsers();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                client.close();
            }
        }

        private void checkNotOnlineUsers() {
            Date currentTime = new Date();
            for (User user : users) {
                if (notOnline(currentTime, user)) {
                    user.setOnline(false);
                }
            }
        }

        private boolean notOnline(Date currentTime, User user) {
            return currentTime.getTime() - user.getLastOnlineTime().getTime() >= Globle.DEAD_TIME;
        }

        private void freshUserInfo() throws IOException {
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            client.receive(packet);
            User user = new User(
                    new String(packet.getData(), 0, packet.getLength()), packet.getAddress(), true, new Date());
            if (users.contains(user)) {
                users.remove(user);
            }
//            System.out.println(packet.getAddress());
            users.add(user);
//            System.out.println("==========user:");
        }
    }
}
