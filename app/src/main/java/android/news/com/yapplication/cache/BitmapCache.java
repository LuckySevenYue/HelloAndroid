package android.news.com.yapplication.cache;

import android.graphics.Bitmap;
import android.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * Created by yy10017 on 2016/8/25.
 * 图片缓存
 */

public class BitmapCache {

    private static final int HARD_CACHE_SIZE = 10 * 1024 * 1024;
    private static final int SOFT_CACHE_SIZE = 40;

    private final LinkedHashMap<String, SoftReference<Bitmap>> sSoftBitmapMap =
            new LinkedHashMap<String, SoftReference<Bitmap>>(SOFT_CACHE_SIZE, 0.75f, true) {//(默认)false:基于插入顺序,true:基于访问顺序
                @Override
                public SoftReference<Bitmap> put(String key, SoftReference<Bitmap> value) {
                    return super.put(key, value);
                }

                @Override
                protected boolean removeEldestEntry(Entry<String, SoftReference<Bitmap>> eldest) {
                    if (size() > SOFT_CACHE_SIZE){
                        return true;
                    }
                    return false;
                }
            };


    private final LruCache<String, Bitmap> sHardBitmapCache = new LruCache<String, Bitmap>(HARD_CACHE_SIZE) {

        @Override
        protected int sizeOf(String key, Bitmap value) {
            return super.sizeOf(key, value);
        }

        @Override
        protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
            super.entryRemoved(evicted, key, oldValue, newValue);
            sSoftBitmapMap.put(key, new SoftReference<>(oldValue));
        }
    };

    public boolean putBitmap(String key, Bitmap value){
        if (value != null){
            synchronized (sHardBitmapCache){
                sHardBitmapCache.put(key, value);
            }
            return true;
        }
        return false;
    }


    public Bitmap getBitmap(String key){
        //get from hardCache
        synchronized (sHardBitmapCache){
            final Bitmap bitmap = sHardBitmapCache.get(key);
            if (bitmap != null){
                return bitmap;
            }
        }
        //get from softCache
        SoftReference<Bitmap> softReference = sSoftBitmapMap.get(key);
        if (softReference != null){
            Bitmap bitmap = softReference.get();
            if (bitmap != null){
                return bitmap;
            } else {
                sSoftBitmapMap.remove(key);//soft reference 已被回收
            }
        }
        return null;
    }
}
