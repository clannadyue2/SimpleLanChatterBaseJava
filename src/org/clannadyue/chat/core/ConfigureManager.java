package org.clannadyue.chat.core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 配置管理器，对一些配置参数进行管理，采用单例模式
 */
public class ConfigureManager {

    private static ConfigureManager configMan = new ConfigureManager();
    private Map<String, Object> maps;

    public Map<String, Object> getConfigs() {
        return maps;
    }

    private ConfigureManager() {
        maps = new HashMap<String, Object>();
        init();
    }

    private void init() {
        initMultiCastAddrs();
        //initUserInfo();
    }

    private void initUserInfo(String userName) {
        try {
            maps.put(Globle.USER, new User(userName, InetAddress.getLocalHost(), true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initMultiCastAddrs() {
        try {
            maps.put(Globle.MULTI_CAST_ADDR, InetAddress.getByName("224.0.1.1"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void setUserName(String userName) {
        String name = userName;
        if (userName == null || userName.equals("")) {
            try {
                name = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException ex) {
                Logger.getLogger(ConfigureManager.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
        initUserInfo(name);
    }

    public static ConfigureManager getInstance() {
        return configMan;
    }
}
