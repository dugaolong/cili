package www.dugaolong.com.xianshishigongjiao.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import www.dugaolong.com.xianshishigongjiao.R;
import www.dugaolong.com.xianshishigongjiao.utils.ActivityManager;


/**
 * Created by dugaolong on 17/9/11.
 */

public class IndexActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private ListView mListView;

    private ArrayAdapter mAdapter;

    private List<String> listOld = new ArrayList<>();
    private List<String> listNew = new ArrayList();
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.index);
        // 得到联系人名单的指针

        initViews();

        listOld.add("战狼2");
        listOld.add("维多利亚");
        listOld.add("杨幂");
        listOld.add("王李丹妮");
        listOld.add("郭书瑶");
        listOld.add("老炮儿");
        listOld.add("服务");
        listOld.add("主播");
        listOld.add("avi");
        listOld.add("av");

        listNew.addAll(listOld);

        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listNew);
        // 添加Activity到堆栈
        ActivityManager.getAppManager().addActivity(this);
    }

    /**
     * 初始化视图
     */
    private void initViews() {

        mListView = (ListView) findViewById(R.id.listView);
//        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        mListView.setTextFilterEnabled(true);
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(mListView.getWindowToken(), 0); // 输入法如果是显示状态，那么就隐藏输入法
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        mSearchView = (SearchView) findViewById(R.id.searchView);
        mSearchView.setIconifiedByDefault(false);
//        mSearchView.setSubmitButtonEnabled(true);
//        mSearchView.onActionViewExpanded();
//        mSearchView.setBackgroundColor(0x2200aa00);
//        mSearchView.setBackgroundResource(R.color.blue1);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            private String TAG = getClass().getSimpleName();
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String queryText) {
                Log.d(TAG, "onQueryTextSubmit = " + queryText);

                if (mSearchView != null) {
                    // 得到输入管理对象
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        // 这将让键盘在所有的情况下都被隐藏，但是一般我们在点击搜索按钮后，输入法都会乖乖的自动隐藏的。
                        imm.hideSoftInputFromWindow(mSearchView.getWindowToken(), 0); // 输入法如果是显示状态，那么就隐藏输入法
                    }
                    mSearchView.clearFocus(); // 不获取焦点
                }
                return true;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String queryText) {
                Log.d(TAG, "onQueryTextChange = " + queryText);
                str = queryText;

                for (String temp : listOld) {
                    if (temp.contains(queryText)) {
                        listNew.add(temp);
                    }
                }
                mAdapter.notifyDataSetChanged(); // 交换指针，展示新的数据
                return true;
            }
        });
    }

    public void onButtonClick(View view){
//        Toast.makeText(this,"button",Toast.LENGTH_LONG).show();
        if(TextUtils.isEmpty(str))
            return;
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,TabLayoutActivity.class);
        intent.putExtra("data",str);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        OkHttpProxy.cancel(OkHttpManager.getInstance());
        // 结束Activity&从堆栈中移除
        ActivityManager.getAppManager().finishActivity(this);
    }
}
