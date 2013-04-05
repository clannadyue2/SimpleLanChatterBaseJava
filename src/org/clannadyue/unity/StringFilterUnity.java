package org.clannadyue.unity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串过滤操作的工具类
 */
public class StringFilterUnity {

    public static String getSingerFilteredStr(String str, String regex) {
        Matcher m = Pattern.compile(regex).matcher(str);
        if (m.find()) {
            return m.group();
        }
        return "";
    }

    public static List<String> getAllFilteredStr(String str, String regex) {
        Matcher m = Pattern.compile(regex).matcher(str);
        List<String> filteredStr = new ArrayList<String>();
        while (m.find()) {
            filteredStr.add(m.group());
        }
        return filteredStr;
    }
}
