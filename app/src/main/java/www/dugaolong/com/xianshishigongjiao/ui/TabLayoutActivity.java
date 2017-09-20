package www.dugaolong.com.xianshishigongjiao.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import www.dugaolong.com.xianshishigongjiao.R;
import www.dugaolong.com.xianshishigongjiao.adapter.MyAdapter;
import www.dugaolong.com.xianshishigongjiao.fragment.FragmentIHome;
import www.dugaolong.com.xianshishigongjiao.fragment.MyFragmentFive;
import www.dugaolong.com.xianshishigongjiao.fragment.MyFragmentFour;
import www.dugaolong.com.xianshishigongjiao.fragment.MyFragmentOne;
import www.dugaolong.com.xianshishigongjiao.fragment.MyFragmentSeven;
import www.dugaolong.com.xianshishigongjiao.fragment.MyFragmentSix;
import www.dugaolong.com.xianshishigongjiao.fragment.MyFragmentThree;
import www.dugaolong.com.xianshishigongjiao.fragment.MyFragmentTwo;

/**
 * Created by dugaolong on 17/3/21.
 */

public class TabLayoutActivity extends AppCompatActivity {
    public static final String TAG = "TabLayoutActivity";
    private TabLayout mTabLayout ;
    private ViewPager mViewPager ;

    private List<Fragment> list_Fragments ;
    private List<String> list_Titles ;

    private MyAdapter mMyAdapter ;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tablayout);
        initView();
        getData();
        initData();
    }

    private void initView() {
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


    private void initData() {
        list_Fragments = new ArrayList<>();
        list_Titles = new ArrayList<>();

        list_Fragments.add(new MyFragmentFive(this,"http://www.btanv.com/search/"+data+"-first-asc-1"));
        list_Fragments.add(new FragmentIHome(this,"http://www.ciliku.com/main-search-kw-"+data+".html"));
        list_Fragments.add(new MyFragmentOne(this,"http://www.btcar.net/search/"+data+"_ctime_1.html"));
        list_Fragments.add(new MyFragmentFour(this,"http://www.btcerise.com/search?keyword="+data));
        list_Fragments.add(new MyFragmentSix(this,"http://www.btba.com.cn/search?keyword="+data));
        list_Fragments.add(new MyFragmentSeven(this,"http://www.btdx8.com/?s="+data));
        list_Fragments.add(new MyFragmentThree(this,"http://www.bthai.net/list/"+data+"-s1d-1.html"));
        list_Fragments.add(new MyFragmentTwo(this,"http://so.54new.com/cse/search?s=5765014479258254613&ie=gbk&q="+data));


        list_Titles.add("bt1");
        list_Titles.add("bt2");
        list_Titles.add("bt3");
        list_Titles.add("bt4");
        list_Titles.add("bt5");
        list_Titles.add("bt6");
        list_Titles.add("bt7");
        list_Titles.add("bt8");

        mMyAdapter = new MyAdapter(getSupportFragmentManager(),list_Fragments,list_Titles);
        mViewPager.setAdapter(mMyAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public void getData() {

        this.data = getIntent().getStringExtra("data");
    }
}
