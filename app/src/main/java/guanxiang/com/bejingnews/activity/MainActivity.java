package guanxiang.com.bejingnews.activity;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import guanxiang.com.bejingnews.R;
import guanxiang.com.bejingnews.utils.DensityUtil;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置主页面
        setContentView(R.layout.activity_main);

        //设置左侧菜单
        setBehindContentView(R.layout.activity_leftmenu);

        //设置右侧菜单
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.activity_rightmenu);

        //设置显示的模式
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置滑动模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //设置主页占据宽度
        slidingMenu.setBehindOffset(DensityUtil.dip2px(MainActivity.this,200));

    }
}
