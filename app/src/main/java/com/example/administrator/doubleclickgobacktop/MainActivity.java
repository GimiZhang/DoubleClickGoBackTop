package com.example.administrator.doubleclickgobacktop;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.doubleclickgobacktop.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainBean bean = new MainBean("双击返回顶部");
    private ActivityMainBinding mainBinding;
    private List<ItemBean> data = new ArrayList<>();
    private RecycleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setMainbean(bean);
        initView();
    }

    private void initView() {
        for (int i = 0; i < 100; i++) {
            ItemBean bean = new ItemBean();
            bean.setContent("测试双击事件"+i);
            data.add(bean);
        }

        mainBinding.recycle.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecycleAdapter(this,data);
        mainBinding.recycle.setAdapter(mAdapter);
        mainBinding.setMaindouble(new MainDataClick());
    }

    public class MainDataClick{
        public long startTime = 0;
        public long endTime = 0;
        public boolean doubleFlag = true;
        public void onTvTitleDoubleClick(View view){
            if(doubleFlag){
                startTime = System.currentTimeMillis();
                doubleFlag = false;
                return;
            }

            if(!doubleFlag){
                endTime = System.currentTimeMillis();
                doubleFlag = true;
                if((endTime - startTime) < 350){
                    Toast.makeText(MainActivity.this, (endTime - startTime)+"ms返回顶部", Toast.LENGTH_SHORT).show();
                    mainBinding.recycle.scrollToPosition(0);

                }
            }

        }
    }
}
