package guanxiang.com.bejingnews.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import guanxiang.com.bejingnews.base.BasePager;

/**
 * @创建者 李明
 * @创建时间 2019/1/30 13:09
 * 描述
 */
public class HomePager extends BasePager {
    public HomePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        //设置标题
        tv_title.setText("主页面");
        //联网请求得到数据，创建视图
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        //把子视图添加到BasePager的FrameLayout中
        fl_content.addView(textView);
        //绑定数据
        textView.setText("我是主页面内容");
    }
}
