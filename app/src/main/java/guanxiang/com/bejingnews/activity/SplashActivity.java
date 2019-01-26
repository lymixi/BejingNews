package guanxiang.com.bejingnews.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import guanxiang.com.bejingnews.R;
import guanxiang.com.bejingnews.utils.CacheUtils;

public class SplashActivity extends Activity {

    /**
     * 静态常量
     */
    public static final String START_MAIN = "start_main";
    private RelativeLayout rl_splash_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();

    }

    private void initView() {
        //实例化视图布局
        rl_splash_root = findViewById(R.id.rl_splash_root);

        //渐变动画,缩放动画,旋转动画
        AlphaAnimation aa = new AlphaAnimation(0,1);
//        aa.setDuration(500);
        aa.setFillAfter(true);

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);

//        sa.setDuration(500);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
//        ra.setDuration(500);
        ra.setFillAfter(true);

        AnimationSet animationSet =new AnimationSet(false);
        //添加三个动画没有先后顺序,便于同时播放电话
        animationSet.addAnimation(aa);
        animationSet.addAnimation(sa);
        animationSet.addAnimation(ra);
        animationSet.setDuration(1000);

        rl_splash_root.startAnimation(animationSet);
        animationSet.setAnimationListener(new MyAnimationListener());

    }

    class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(SplashActivity.this,"动画播放完成了",Toast.LENGTH_SHORT).show();
            //判断是否进入过主页面
            boolean isStartMain = CacheUtils.getBoolean(SplashActivity.this, START_MAIN);
            if(isStartMain){


            }else{
                Intent intent= new Intent(SplashActivity.this,GuideActivity.class);
                startActivity(intent);
            }

            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
