package com.example.administrator.cycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MyCycleView extends AppCompatActivity {
    List<Cat> catList = new ArrayList<Cat>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cycle_view);

        initCat();
        final RecyclerView recyclerView = findViewById(R.id.recycleView);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ScrollSpeedLinearLayoutManger layoutManager = new ScrollSpeedLinearLayoutManger(this);
        layoutManager.setSpeedSlow();
        //横向的recycleview
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        CatAdapter adapter = new CatAdapter(catList);
        recyclerView.setAdapter(adapter);

        final Thread tr  = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i!=1; i++) {
                    try {
                        Thread.sleep(1000);
                        recyclerView.smoothScrollToPosition(8);
                    } catch (InterruptedException e) {

                    }
                }
            }
        });
        tr.start();
    }

    private void initCat() {
        Cat cat1 = new Cat("cat1", R.drawable.dahuangmao01);
        catList.add(cat1);
        Cat cat2 = new Cat("cat2", R.drawable.dahuangmao02);
        catList.add(cat2);
        Cat cat3 = new Cat("cat3", R.drawable.dahuangmao03);
        catList.add(cat3);
        Cat cat4 = new Cat("cat4", R.drawable.dahuangmao04);
        catList.add(cat4);
        Cat cat5 = new Cat("cat5", R.drawable.dahuangmao05);
        catList.add(cat5);
        Cat cat6 = new Cat("cat6", R.drawable.dahuangmao06);
        catList.add(cat6);
        Cat cat7 = new Cat("cat7", R.drawable.dahuangmao07);
        catList.add(cat7);
        Cat cat8 = new Cat("cat8", R.drawable.dahuangmao08);
        catList.add(cat8);


        catList.add(cat6);
        Cat cat9 = new Cat("cat7", R.drawable.dahuangmao07);
        catList.add(cat9);
        Cat cat10 = new Cat("cat8", R.drawable.dahuangmao08);
        catList.add(cat10);
    }
}
