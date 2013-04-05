package org.clannadyue.chat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.clannadyue.chat.core.Message;

/**
 * 代表数据操作器，提供数据存储方面的功能
 */
public class DbOperator {

    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    private static final String dbName = "C:\\Users\\hp\\workspace\\chatBaseUdpT\\db";

    public static void insertMessage(String userName, String ip, Message message) {
//		Connection conn = null;
//		Statement state = null;
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(protocol + dbName + 
//					";create=true");
//			state = conn.createStatement();
//			state.executeUpdate("insert into message_info values('" +
//					 userName + "','" + ip + "','" + message.getContent() +
//					  "','" + message.getReceiveTime().toLocaleString() + "')");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				state.close();
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
    }

    public static List<String> getContent() {
        List<String> infos = new ArrayList<String>();
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(protocol + dbName
                    + ";create=true");
            state = conn.createStatement();
            rs = state.executeQuery("select * from message_info");
            while (rs.next()) {
                infos.add(rs.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                state.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return infos;
    }
//	public static void main(String[] args) {
//		DbOperator.insertMessage("chen6", "134", new Message("hello", new Date()));
//		//DbOperator.insertMessage("chen2", "134", new Message("hello", new Date()));
//		//DbOperator.insertMessage("chen3", "134", new Message("hello", new Date()));
//		for (String str : DbOperator.getContent()) {
//			System.out.println(str);
//		}
//		System.out.println(new Date());
//		System.out.println(new Date().toGMTString());
//		System.out.println(new Date().toLocaleString());
//	}
}
