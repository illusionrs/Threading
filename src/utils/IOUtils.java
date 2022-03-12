package utils;

import java.io.*;

public class IOUtils {

    public static void copy(String src, String dest) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(src);
        FileOutputStream fileOutputStream = new FileOutputStream(dest);

        int value ;
        while ((value = fileInputStream.read())!=-1){
            fileOutputStream.write(value);
        }

    }
}
