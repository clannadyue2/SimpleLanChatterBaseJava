package org.clannadyue.unity;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 屏幕相关操作的工具类
 */
public class Screen {

    private static Dimension screenSize;

    static {
        Toolkit kit = Toolkit.getDefaultToolkit();
        screenSize = kit.getScreenSize();
    }

    public static int getScreenWidth() {
        return screenSize.width;
    }

    public static int getScreenHeight() {
        return screenSize.height;
    }

    /**
     * 根据当前的屏幕环境调节组件的位置，将其调制屏幕正中间
     *
     * @param com 待调节的组件
     */
    public static void suitLocation(Component com) {
        int screenWidth = Screen.getScreenWidth();
        int screenHeight = Screen.getScreenHeight();
        com.setLocation((screenWidth - com.getWidth()) / 2,
                (screenHeight - com.getHeight()) / 2);
    }
}
