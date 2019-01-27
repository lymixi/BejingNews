package guanxiang.com.bejingnews.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author liming
 * @data 2019/1/27
 * 基本的Fragment
 */
public abstract class BaseFragment extends Fragment{

    public Context context;


    /**
     * 当Fragment被创建的时候回调
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context =  getActivity();
    }

    /**
     * 当视图被创建的时候回调
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();

    }

    /**
     * 让孩子实现自己的视图
     * @return
     */
    public abstract View initView() ;

    /**
     * 当Activity被创建之后回调
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 1.如果页面没有数据，联网请求数据，并绑定到视图
     */
    public void initData() {

    }
}
