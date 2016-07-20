package com.example.qiyue.imageloader.utils;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.example.qiyue.imageloader.R;
import com.nostra13.universalimageloader.core.ImageLoader;

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
}
