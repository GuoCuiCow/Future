package com.gebilaowang.example.future.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gebilaowang.example.future.R;

public class NewsDetailActivity extends AppCompatActivity {
    public static final String EXTRA_KEY_NEWS_ID = "key_news_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        long id = getIntent().getLongExtra(EXTRA_KEY_NEWS_ID, -1);
    }
}
