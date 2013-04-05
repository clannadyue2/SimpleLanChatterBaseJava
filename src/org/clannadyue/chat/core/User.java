package org.clannadyue.chat.core;

import java.net.InetAddress;
import java.util.Date;

/**
 * 代表用户
 */
public class User {

    private String name;
    private InetAddress loginIp;
    private boolean online;
    private Date lastOnlineTime;

    public User(String name, InetAddress loginIp, boolean online) {
        this(name, loginIp, online, null);
    }

    public User(String name, InetAddress loginIp, boolean online,
            Date lastOnlineTime) {
        super();
        this.name = name;
        this.loginIp = loginIp;
        this.online = online;
        this.lastOnlineTime = lastOnlineTime;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public InetAddress getLoginIp() {
        return loginIp;
    }

    public Date getLastOnlineTime() {
        return lastOnlineTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o instanceof User) {
            User user = (User) o;
            return user.getName().equals(this.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
