package guanxiang.com.bejingnews.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import guanxiang.com.bejingnews.R;

/**
 * @author liming
 * @data 2019/1/27
 */
public class BasePager {

    public final Context context;
    public  View rootView;

    public TextView tv_title;
    public ImageButton ib_menu;
    public FrameLayout fl_content;

    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    public View initView(){
        View view = View.inflate(context, R.layout.base_pater,null);
        tv_title = view.findViewById(R.id.tv_title);
        ib_menu = view.findViewById(R.id.ib_menu);
        fl_content = view.findViewById(R.id.fl_content);
        return view;
    }

    public void initData(){

    }
}
