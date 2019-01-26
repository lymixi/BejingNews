package guanxiang.com.bejingnews.activity;

import android.app.Activity;
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

import java.util.ArrayList;

import guanxiang.com.bejingnews.R;

public class GuideActivity extends Activity implements View.OnClickListener {
    private ViewPager viewpager;
    private Button btn_start_main;
    private LinearLayout ll_point_group;

    private ArrayList<ImageView> imageViews;
    private ImageView iv_red_point;
    private int leftmax;

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


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10,10);
           if(i != 0){
               params.leftMargin=10;
           }
            point.setLayoutParams(params);

            ll_point_group.addView(point);
        }

        //设置ViewPage的适配器
        viewpager.setAdapter(new MyApagerAdapter());

        //根据View生命周期，
        iv_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListene());

        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionoffset, int positionoffsetpixels) {

        }

        @Override
        public void onPageSelected(int i) {

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
