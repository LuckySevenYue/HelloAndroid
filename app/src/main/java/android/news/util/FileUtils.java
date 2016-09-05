package android.news.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yy10017 on 2016/8/23.
 *
 */

public class FileUtils {

    public static File save(byte[] buf) throws IOException{
        File file = new File("/mnt/sdcard/a.png");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(buf);
        fos.flush();
        fos.close();
        return file;
    }

    public static void makeFile(final byte[] buf , final ICallback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final File file = save(buf);
                    callback.doFile(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

//    static File file = null;
//
//    private static Handler handler = new Handler();
//
//    private static ICallback iCallback;
//
//
//
//
//    public static void makeFile(final InputStream in, ICallback i) {
//
//        iCallback = i;
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    FileOutputStream out = null;
//                    String fileName = String.valueOf(System.currentTimeMillis());
//                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//
//                        File parent = Environment.getExternalStorageDirectory();
//                        file = new File(parent, fileName);
//                        out = new FileOutputStream(file);
//                    }
//                    byte[] buf = new byte[1024];
//                    int len;
//                    if (out != null) {
//                        while ((len = in.read(buf)) != -1) {
//                            out.write(buf, 0, len);
//                        }
//                        out.flush();
//                        out.close();
//                    }
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            iCallback.doFile(file);
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
}
