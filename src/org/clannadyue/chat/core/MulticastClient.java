package org.clannadyue.chat.core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 代表广播时的发送客户端，由UserManager进行调用
 */
public class MulticastClient implements Runnable {

    private DatagramSocket client;
    private User user;
    private InetAddress multicastAddr;

    public MulticastClient(User user, InetAddress ip) throws SocketException {
        this.user = user;
        this.multicastAddr = ip;
        client = new DatagramSocket();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String userInfo = user.getName();
                DatagramPacket packet =
                        new DatagramPacket(userInfo.getBytes(),
                        userInfo.length(), this.multicastAddr, Globle.MULTI_CAST_PORT);
                client.send(packet);
                Thread.sleep(Globle.MULTI_CAST_WAIT_TIME);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}
