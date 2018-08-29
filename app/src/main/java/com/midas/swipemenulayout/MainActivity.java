package com.midas.swipemenulayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.midas.swipemenulayout.listview.ListViewActivity;
import com.midas.swipemenulayout.recyclerview.RecyclerActivity;
import com.midas.swipemenulayout.one.OthersActivity;
import com.midas.swipemenulayout.view.LinearLayoutActivity;
import com.midas.swipemenulayout.viewpager.ViewPagerActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), RecyclerActivity.class));
            }
        });

        findViewById(R.id.lv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ListViewActivity.class));
            }
        });

        findViewById(R.id.ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), LinearLayoutActivity.class));
            }
        });

        findViewById(R.id.viewPager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
            }
        });
        findViewById(R.id.others).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OthersActivity.class));
            }
        });
    }
}
