package org.clannadyue.chat.core;

import java.util.Date;

/**
 * 代表消息
 */
public class Message {

    private String content;
    private Date receiveTime;

    public Message(String content) {
        super();
        this.content = content;
    }

    public Message(String content, Date receiveTime) {
        super();
        this.content = content;
        this.receiveTime = receiveTime;
    }

    public String getContent() {
        return content;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }
}