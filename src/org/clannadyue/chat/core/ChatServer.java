package org.clannadyue.chat.core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clannadyue.chat.dao.DbOperator;

/**
 * 代表聊天服务器，采用单例模式，会监听并收集用户的聊天信息
 */
public class ChatServer implements Runnable {

    private static ChatServer chatServer = new ChatServer();
    private Map<String, Queue<Message>> receiveMess;
    private UserManager userManager;
    private DatagramSocket server;
    public static final int DEFAULT_PORT = 4000;

    public static ChatServer getInstance() {
        return chatServer;
    }

    public ChatServer() {
        try {
            server = new DatagramSocket(DEFAULT_PORT);
            receiveMess = new HashMap<String, Queue<Message>>();
            userManager = UserManager.getInstance();
        } catch (SocketException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                server.receive(packet);
                savaMessage(packet);
                //System.out.println(new String(packet.getData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Queue<Message> getMessagesByUserName(String userName) {
        return receiveMess.get(userName);
    }

    public boolean hasMessagesOfUser(String userName) {
        return receiveMess.get(userName) != null;
    }

    private void savaMessage(DatagramPacket packet) {
        String userName = userManager.getUserNameByIp(packet.getAddress());
        if (userName != null) {
            Queue<Message> messes = null;
            if (receiveMess.get(userName) != null) {
                messes = new LinkedList<Message>(receiveMess.get(userName));
            } else {
                messes = new LinkedList<Message>();
            }
            Message message = new Message(new String(packet.getData(), 0, packet.getLength()), new Date());
            messes.add(message);
            receiveMess.put(userName, messes);
            System.out.println(packet.getAddress().getHostAddress().length());
            System.out.println(userName.length());
            DbOperator.insertMessage(userName, packet.getAddress().getHostAddress(), message);
        }
    }
}