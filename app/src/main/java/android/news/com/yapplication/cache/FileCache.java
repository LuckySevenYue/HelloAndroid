package android.news.com.yapplication.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yy10017 on 2016/8/25.
 * SD缓存
 */

public class FileCache {

    private Context mContext;

    private File mCacheFile = mContext.getCacheDir();

    private static final int MAX_CACHE_SIZE = 10 * 1024 *1024;

    private final LruCache<String,Long> mFileCache = new LruCache<String, Long>(MAX_CACHE_SIZE){
        @Override
        protected int sizeOf(String key, Long value) {
            return super.sizeOf(key, value);
        }

        @Override
        protected void entryRemoved(boolean evicted, String key, Long oldValue, Long newValue) {
            super.entryRemoved(evicted, key, oldValue, newValue);
            try {
                File file = getFile(key);
                if (file != null){
                    file.delete();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    };

    private File getFile(String key) throws FileNotFoundException {
        File file = new File(mCacheFile,key);
        if (!file.exists() || !file.isFile()){
            throw new FileNotFoundException("file is not exit or it's not file");
        }
        return file;
    }

    //缓存 Bitmap 到外部存储
    public boolean putBitmap(String key, Bitmap bitmap) throws IOException {
        File file = getFile(key);
        if (file != null){
            return true;
        }
        FileOutputStream fos = getOutputStream(key);
        boolean saved = bitmap.compress(Bitmap.CompressFormat.JPEG,100,fos);
        fos.flush();
        fos.close();
        if (saved){
            synchronized (mFileCache){
                mFileCache.put(key,getFile(key).length());
            }
            return true;
        }
        return false;
    }

    //根据key获取OutputStream
    private FileOutputStream getOutputStream(String key) throws FileNotFoundException {
        if (mCacheFile == null){
            return null;
        }
        FileOutputStream fos = new FileOutputStream(mCacheFile.getAbsolutePath() + File.separator + key);
        return fos;
    }

    private static BitmapFactory.Options sBitmapOptions;
    static {
        sBitmapOptions = new BitmapFactory.Options();
        sBitmapOptions.inPurgeable = true; //bitmap can be purged to disk
    }

    private Bitmap getBitmap(String key) throws FileNotFoundException {
        File bitmapFile = getFile(key);
        if (bitmapFile != null){
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(bitmapFile),null,sBitmapOptions);
            if (bitmap != null){
                //重新将其缓存至硬引用中
            }
        }
        return null;
    }

}
