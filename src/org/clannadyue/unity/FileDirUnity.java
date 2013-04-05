package org.clannadyue.unity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作的工具类
 */
public class FileDirUnity {

    public static String getFileNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    public static void makeDir(String dirName) {
        File dir = new File(dirName);
        dir.mkdir();
    }

    public static void createFile(String fileName, InputStream in) throws IOException {
        OutputStream out = new FileOutputStream(new File(fileName));
        byte[] b = new byte[1];
        while (in.read(b) != -1) {
            out.write(b);
        }
        in.close();
        out.close();
    }
}
