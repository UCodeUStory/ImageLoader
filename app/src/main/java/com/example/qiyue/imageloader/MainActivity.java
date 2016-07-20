package com.example.qiyue.imageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.qiyue.imageloader.utils.GlideCircleTransform;
import com.example.qiyue.imageloader.utils.GlideRoundTransform;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private RequestManager glideRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);

        glideRequest = Glide.with(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                glideRequest.load("https://www.baidu.com/img/bdlogo.png").into(imageView);
                break;
            case R.id.button2:
                glideRequest.load("https://www.baidu.com/img/bdlogo.png").transform(new GlideRoundTransform(this)).into(imageView);
                break;
            case R.id.button3:
                glideRequest.load("https://www.baidu.com/img/bdlogo.png").transform(new GlideRoundTransform(this, 10)).into(imageView);
                break;
            case R.id.button4:
                glideRequest.load("https://www.baidu.com/img/bdlogo.png").transform(new GlideCircleTransform(this)).into(imageView);
                break;
        }
    }
}
