package guanxiang.com.bejingnews.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import guanxiang.com.bejingnews.R;
import guanxiang.com.bejingnews.base.BaseFragment;
import guanxiang.com.bejingnews.utils.LogUtil;

/**
 * @author liming
 * @data 2019/1/27
 * 左侧菜单的Fragment
 */
public class ContentFragment extends BaseFragment {
    @ViewInject(R.id.viewpager)
    private ViewPager viewpager;

    @ViewInject(R.id.rg_main)
    private RadioGroup rg_main;


    @Override
    public View initView() {
        LogUtil.e("正文Fragment页面初始化啦");
        View view = View.inflate(context, R.layout.content_fragment,null);

        x.view().inject(ContentFragment.this,view);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("正文Fragment数据初始化啦");
        rg_main.check(R.id.rb_home);

    }
}
