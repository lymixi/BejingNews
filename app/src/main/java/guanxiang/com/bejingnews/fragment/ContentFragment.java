package guanxiang.com.bejingnews.fragment;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

import guanxiang.com.bejingnews.R;
import guanxiang.com.bejingnews.base.BaseFragment;
import guanxiang.com.bejingnews.base.BasePager;
import guanxiang.com.bejingnews.pager.GovaffairPager;
import guanxiang.com.bejingnews.pager.HomePager;
import guanxiang.com.bejingnews.pager.NewsCenterPager;
import guanxiang.com.bejingnews.pager.SettingCenterPager;
import guanxiang.com.bejingnews.pager.SmartServicePager;
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

    private ArrayList<BasePager> basePagers;


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

        //初始化五个页面,并放入到集合中
        basePagers = new ArrayList<BasePager>();

        basePagers.add(new HomePager(context));
        basePagers.add(new NewsCenterPager(context));
        basePagers.add(new SmartServicePager(context));
        basePagers.add(new GovaffairPager(context));
        basePagers.add(new SettingCenterPager(context));
        //设置默认选中的页面
        rg_main.check(R.id.rb_home);

        //设置ViewPager适配器
        viewpager.setAdapter(new ContentFragmentAdapter());

    }

    class ContentFragmentAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            BasePager basePager = basePagers.get(position);//个个页面的实例
            View rootView = basePager.rootView;//个个子页面
            //调用个个页面的initData()，初始化数据
            basePager.initData();
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
