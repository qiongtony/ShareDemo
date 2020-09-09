package com.example.sharedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sharedemo.adapter.MyAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private Integer value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recycler.setAdapter(new MyAdapter(this));

        exceptionBreakPoint();

        watchVariable();


        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }

    private void exceptionBreakPoint() {
        findViewById(R.id.btnException).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ...一些逻辑
                Log.i("WWS", "apply change");
//                value.intValue();
                Toast.makeText(MainActivity.this, "点击了按钮！", Toast.LENGTH_SHORT).show();
                Log.i("WWS", "after change");
                // ...后续工作
            }
        });
    }

    private void watchVariable() {
        findViewById(R.id.btnWatchVariable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setName("名称" + new Random().nextInt(100));
            }
        });
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    private void setName(String name){
        String updateName = name + "_update";
    }
}