package android.news.com.yapplication.util;

import android.os.Environment;
import android.os.Handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yy10017 on 2016/8/23.
 *
 */

public class FileUtils {
    static File file = null;

    private static Handler handler = new Handler();

    public static File makeFile(final InputStream in) {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                try {
                    FileOutputStream out = null;
                    String fileName = String.valueOf(System.currentTimeMillis());
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

                        File parent = Environment.getExternalStorageDirectory();
                        file = new File(parent, fileName);
                        out = new FileOutputStream(file);
                    }
                    byte[] buf = new byte[1024];
                    int len;
                    if (out != null) {
                        while ((len = in.read(buf)) != -1) {
                            out.write(buf, 0, len);
                        }
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },2000);
        return file;
    }
}
