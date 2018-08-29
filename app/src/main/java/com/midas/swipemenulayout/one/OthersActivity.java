package com.midas.swipemenulayout.one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.mcxtzhang.commonadapter.lvgv.CommonAdapter;
import com.mcxtzhang.commonadapter.lvgv.ViewHolder;
import com.midas.swipemenulayout.R;
import com.midas.swipemenulayout.DataBean;
import com.midas.swipemenulibrary.one.EasySwipeMenuLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 另一种实现方式
 */
public class OthersActivity extends AppCompatActivity {

    private ListView listView;
    private List<DataBean> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        initData();
        initView();
    }


    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CommonAdapter<DataBean>(this, listData, R.layout.item_rv_swipemenu) {
            @Override
            public void convert(final ViewHolder viewHolder, DataBean swipeBean, final int position) {
                viewHolder.setText(R.id.content_tv, swipeBean.name);
                viewHolder.setOnClickListener(R.id.content, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(OthersActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                    }

                });
                viewHolder.setOnClickListener(R.id.right_menu_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(OthersActivity.this, "收藏" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolder.setOnClickListener(R.id.right_menu_delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(OthersActivity.this, "删除:" + position, Toast.LENGTH_SHORT).show();
                        EasySwipeMenuLayout easySwipeMenuLayout = viewHolder.getView(R.id.es);
                        easySwipeMenuLayout.resetStatus();
                        listData.remove(position);
                        notifyDataSetChanged();
                    }
                });

            }
        });


    }

    private void initData() {
        listData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            // listData.add("index is =" + i);
            listData.add(new DataBean("index is =" + i));
        }
    }
}
