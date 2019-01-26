package guanxiang.com.bejingnews.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author liming
 * @data 2019/1/26
 * 缓存工具类
 */
public class CacheUtils {

    /**
     * 得到缓存值
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {

        SharedPreferences sp = context.getSharedPreferences("guanxiang",Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }
}
