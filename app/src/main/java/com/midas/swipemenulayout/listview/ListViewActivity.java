package com.midas.swipemenulayout.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.mcxtzhang.commonadapter.lvgv.CommonAdapter;
import com.mcxtzhang.commonadapter.lvgv.ViewHolder;
import com.midas.swipemenulayout.R;
import com.midas.swipemenulayout.DataBean;
import com.midas.swipemenulibrary.two.SwipeMenuLayout;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends AppCompatActivity {

    private ListView mLv;
    private List<DataBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mLv = (ListView) findViewById(R.id.test);

        initData();
        mLv.setAdapter(new CommonAdapter<DataBean>(this, mData, R.layout.item_cst_swipe) {

            @Override
            public void convert(final ViewHolder holder, DataBean swipeBean, final int position) {
                //((SwipeMenuLayout)holder.getConvertView()).setIos(false);//这句话关掉IOS阻塞式交互效果
                holder.setText(R.id.content, swipeBean.name);
                holder.setOnClickListener(R.id.content, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ListViewActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                    }
                });

                holder.setOnClickListener(R.id.btnDelete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ListViewActivity.this, "删除:" + position, Toast.LENGTH_SHORT).show();
                        //在ListView里，点击侧滑菜单上的选项时，如果想让侧滑菜单同时关闭，调用这句话
                        ((SwipeMenuLayout) holder.getConvertView()).quickClose();
                        mData.remove(position);
                        notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add(new DataBean("" + i));
        }
    }
}
