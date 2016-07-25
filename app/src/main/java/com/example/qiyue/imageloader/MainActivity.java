package com.example.qiyue.imageloader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.qiyue.imageloader.utils.GlideCircleTransform;
import com.example.qiyue.imageloader.utils.GlideRoundTransform;
import com.example.qiyue.imageloader.utils.GlideUtils;
import com.example.qiyue.imageloader.utils.ImageLoaderUtils;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private RequestManager glideRequest;

    ListView mListView;
    protected String[] items = {"Glide带展位图加载",
            "Glide-centerCrop加载",
            "Glide加载圆角图片",
            "Glide加载圆形图片",
            "Glide-fitCenter加载",
            "Glide加载本地图片",
            "ImageLoader加载图片",
            "ImageLoader-center",
            "ImageLoader-centerInside",
            "ImageLoader-fitxy",
            "ImageLoader监听加载过程"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        imageView = (ImageView) findViewById(R.id.imageView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        mListView.setAdapter(adapter);
        final String url = "http://www.pptbz.com/pptpic/UploadFiles_6909/201110/20111014111307895.jpg";
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        GlideUtils.display(imageView,"http://www.pptbz.com/pptpic/UploadFiles_6909/201110/20111014111307895.jpg");
                        break;
                    case 1:
                        GlideUtils.displayCenterCrop(imageView,"http://www.pptbz.com/pptpic/UploadFiles_6909/201110/20111014111307895.jpg");
                        break;
                    case 2:
                        GlideUtils.displayRound(imageView,"http://www.pptbz.com/pptpic/UploadFiles_6909/201110/20111014111307895.jpg",10);
                        break;
                    case 3:
                        GlideUtils.displayCircle(imageView,"http://www.pptbz.com/pptpic/UploadFiles_6909/201110/20111014111307895.jpg");
                        break;
                    case 4:
                        GlideUtils.displayFitCenter(imageView,"http://www.pptbz.com/pptpic/UploadFiles_6909/201110/20111014111307895.jpg");
                        break;
                    case 5:
                        GlideUtils.displayNative(imageView,R.drawable.native_image);
                        break;
                    case 6:
                        ImageLoader.getInstance().displayImage(url,imageView);
                        break;
                    case 7:
                        ImageLoaderUtils.displayImageCenter(url,imageView,R.mipmap.ic_launcher);
                        break;
                    case 8:
                        ImageLoaderUtils.displayImageCenterInSide(url,imageView);
                        break;
                    case 9:
                        ImageLoaderUtils.displayImageFitXY(url,imageView);
                        break;
                    case 10:
                        ImageLoader.getInstance().displayImage(url, imageView, new ImageLoadingListener() {
                            @Override
                            public void onLoadingStarted(String imageUri, View view) {
                                Toast.makeText(MainActivity.this,"加载开始",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                                Toast.makeText(MainActivity.this,"加载失败",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                Toast.makeText(MainActivity.this,"加载完成",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLoadingCancelled(String imageUri, View view) {
                                Toast.makeText(MainActivity.this,"取消加载",Toast.LENGTH_SHORT).show();
                            }
                        });

                        break;
                }
            }
        });

    }


    @Override
    public void onClick(View v) {

    }
}
