package guanxiang.com.bejingnews.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import guanxiang.com.bejingnews.base.BaseFragment;
import guanxiang.com.bejingnews.utils.LogUtil;

/**
 * @author liming
 * @data 2019/1/27
 * 左侧菜单的Fragment
 */
public class ContentFragment extends BaseFragment {

    private TextView textView;
    @Override
    public View initView() {
        LogUtil.e("正文Fragment页面初始化啦");
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("正文Fragment数据初始化啦");
        textView.setText("我是左侧菜单");
    }
}
