package org.clannadyue.chat.core;

/**
 * 保存一些全局常量
 */
public interface Globle {

    /**
     * 代表广播地址所用到的字符串
     */
    String MULTI_CAST_ADDR = "multiCastAddr";
    /**
     * 代表广播所使用的端口号
     */
    int MULTI_CAST_PORT = 3000;
    /**
     * 代表用户表示所使用的字符串
     */
    String USER = "User";
    /**
     * 代表广播的等候时间，即广播的频率，单位ms
     */
    int MULTI_CAST_WAIT_TIME = 5000;
    /**
     * 代表判定用户下线的时间，单位ms
     */
    int DEAD_TIME = 10000;
}
