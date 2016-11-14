package com.gebilaowang.example.future;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gebilaowang.example.future.databinding.ActivityMainBinding;
import com.gebilaowang.example.future.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("loonggg","http://upload-images.jianshu.io/upload_images/966283-d2985f45c0c1e618.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/500", 23);
        binding.setUser(user);
    }
}
