package guanxiang.com.bejingnews.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import guanxiang.com.bejingnews.R;
import guanxiang.com.bejingnews.utils.CacheUtils;
import guanxiang.com.bejingnews.utils.DensityUtil;

public class GuideActivity extends Activity implements View.OnClickListener {
    private ViewPager viewpager;
    private Button btn_start_main;
    private LinearLayout ll_point_group;

    private ArrayList<ImageView> imageViews;
    private ImageView iv_red_point;
    private int leftmax;

    private int widthdpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
        initData();
    }

    private void initView() {
        viewpager = (ViewPager)findViewById( R.id.viewpager );
        btn_start_main = (Button)findViewById( R.id.btn_start_main );
        ll_point_group = (LinearLayout)findViewById( R.id.ll_point_group );
        iv_red_point = findViewById(R.id.iv_red_point);

        btn_start_main.setOnClickListener(this);
    }

    private void initData() {
        //准备数据
        int[] ids = new int[]{
            R.drawable.guide_1,
            R.drawable.guide_2,
            R.drawable.guide_3,

        };
        imageViews = new ArrayList<>();
        for (int i=0;i<ids.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            //添加到集合中
            imageViews.add(imageView);

            //创建点
            //添加到线性布局

            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);

            widthdpi = DensityUtil.dip2px(this,10);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthdpi,widthdpi);
           if(i != 0){
               params.leftMargin=widthdpi;
           }
            point.setLayoutParams(params);

            ll_point_group.addView(point);
        }

        //设置ViewPage的适配器
        viewpager.setAdapter(new MyApagerAdapter());

        //根据View生命周期，
        iv_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListene());

        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());

        //设置按钮的点击事件
        btn_start_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.保存曾经进入过主页面
                CacheUtils.putBoolean(GuideActivity.this,SplashActivity.START_MAIN,true);
                //2.跳转到主页面
                Intent itent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(itent);
                //3.关闭引导页面
                finish();
            }
        });
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionoffset, int positionoffsetpixels) {
            //两点间移动的距离=屏幕滑动百分比*间距
            int leftmargin = (int)(position*leftmax+(positionoffset*leftmax));
            //两点间滑动距离对应的坐标 = 原来的起始位置+两点移动距离

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_red_point.getLayoutParams();
            params.leftMargin  = leftmargin;
            iv_red_point.setLayoutParams(params);
            //params.leftMargin = 两点间滑动距离对应的坐标

        }

        @Override
        public void onPageSelected(int position) {
            if(position == imageViews.size()-1){
                //最后一个页面
                btn_start_main.setVisibility(View.VISIBLE);
            }else{
                btn_start_main.setVisibility(View.GONE);
            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }

    class MyOnGlobalLayoutListene implements ViewTreeObserver.OnGlobalLayoutListener {

        @Override
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                iv_red_point.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

             leftmax = ll_point_group.getChildAt(1).getLeft()-ll_point_group.getChildAt(0).getLeft();

        }
    }

    class MyApagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            container.removeView((View) object);
        }
    }


    @Override
    public void onClick(View v) {

    }
}
