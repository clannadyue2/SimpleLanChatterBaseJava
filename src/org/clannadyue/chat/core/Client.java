package org.clannadyue.chat.core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 代表聊天客户端，完成信息发送的功能
 */
public class Client {

    private static Client clien = new Client();
    private DatagramSocket client;
    private UserManager userManager;

    private Client() {
        try {
            client = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        userManager = UserManager.getInstance();
    }

    public static Client getInstance() {
        return clien;
    }

    /**
     * 向特定ip发送信息
     */
    public void sendMessage(InetAddress ip, String message)
            throws IOException {
        DatagramPacket packet = new DatagramPacket(
                message.getBytes(), message.getBytes().length, ip,
                ChatServer.DEFAULT_PORT);
        client.send(packet);
    }

    /**
     * 向特定用户发送信息
     */
    public void sendMessage(String userName, String message)
            throws IOException {
        InetAddress ip = userManager.getIpByUserName(userName);
        System.out.print("sendMessage " + ip);
        if (ip != null) {
            sendMessage(ip, message);

        }
    }

    public void close() {
        client.close();
    }
    /*private InetAddress getIp(String host) {
     InetAddress ip = null;
     try {
     ip = InetAddress.getByName(host);
     } catch (UnknownHostException e) {
     e.printStackTrace();
     }
     return ip;
     }
     private String readUserInput() {
     BufferedReader reader = new BufferedReader(
     new InputStreamReader(System.in));
     String data = "";
     try {
     data = reader.readLine();
     } catch (IOException e) {
     e.printStackTrace();
     }
     return data;
     }*/
}