package guanxiang.com.bejingnews;

import android.app.Application;

import org.xutils.x;

/**
 * @author liming
 * @data 2019/1/27
 *
 */
public class BejingNewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug(true);
        x.Ext.init(this);
    }
}
