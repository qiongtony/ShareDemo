package com.example.sharedemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sharedemo.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private Button mButton;
    private Button mBtnException;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(this);
        recycler.setAdapter(mAdapter);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(view -> {
            List<String> stringList = getList();
            mAdapter.setDataList(stringList);
            layoutManager.scrollToPosition(0);
        });

        mBtnException = findViewById(R.id.btnException);
        mBtnException.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     List<String> nullList = new ArrayList<>();
                     nullList.get(1);
                 }
             }

        );

        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.i("RecyclerView", "onScrollStateChanged newState = " + newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.i("RecyclerView", "onScrolled dy = " + dy);
            }
        });
    }

    private List<String> getList() {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            stringList.add("第" + i + "条数据");
        }
        return stringList;
    }
}