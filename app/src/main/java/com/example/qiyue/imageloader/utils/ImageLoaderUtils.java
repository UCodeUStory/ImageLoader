package com.example.qiyue.imageloader.utils;

import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.example.qiyue.imageloader.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class ImageLoaderUtils {
    /***
     * 缩小显示，直到一个边界到达控件范围内
     * @param url
     * @param view
     */
    public static void displayImageCenterInSide(String url,ImageView view){
        view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
       displayImage(url,view,R.mipmap.ic_launcher);
    }

    /***
     * 填充显示
     * @param url
     * @param view
     * @param resId
     */
    public static void displayImageFitXY(String url,ImageView view, @DrawableRes int resId){
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        displayImage(url,view, resId);
    }

    /**
     * 填充显示
     * @param url
     * @param view
     */
    public static void displayImageFitXY(String url,ImageView view){
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        displayImage(url,view, R.mipmap.ic_launcher);
    }
    /**
     *按图片的原来size居中显示，当图片长/宽超过View的长/宽，则截取图片的居中部分显示
     * @param url 图片url
     * @param view
     */
    public static void displayImageCenter(String url,ImageView view){
        view.setScaleType(ImageView.ScaleType.CENTER);
        displayImage(url,view, R.mipmap.ic_launcher);
    }

    /**
     *
     * @param url
     * @param view
     * @param resId  站位图
     */
    public static void displayImageCenter(String url,ImageView view, @DrawableRes int resId){
        view.setScaleType(ImageView.ScaleType.CENTER);
        displayImage(url,view, resId);
    }

    /***
     * 显示图片基类
     * @param url
     * @param view
     * @param resId
     */
    public static void displayImage(String url, ImageView view, @DrawableRes int resId){
        view.setImageResource(resId);
        ImageLoader.getInstance().displayImage(url, view);
    }

    public static void displayImage(String url,ImageView view){
        /**可以在加载前设置option**/
       /* DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_stub) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.ic_empty) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
                .resetViewBeforeLoading(false)  // default 设置图片在加载前是否重置、复位
                .delayBeforeLoading(1000)  // 下载前的延迟时间
                .cacheInMemory(false) // default  设置下载的图片是否缓存在内存中
                .cacheOnDisk(false) // default  设置下载的图片是否缓存在SD卡中
                .preProcessor(...)
        .postProcessor(...)
        .extraForDownloader(...)
        .considerExifParams(false) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default 设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default 设置图片的解码类型
                .decodingOptions(...)  // 图片的解码设置
        .displayer(new SimpleBitmapDisplayer()) // default  还可以设置圆角图片new RoundedBitmapDisplayer(20)
                .handler(new Handler()) // default
                .build();*/
    }


}
