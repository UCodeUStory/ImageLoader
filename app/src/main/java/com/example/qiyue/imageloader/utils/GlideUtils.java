/*
 * {EasyGank}  Copyright (C) {2015}  {CaMnter}
 *
 * This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; type `show c' for details.
 *
 * The hypothetical commands `show w' and `show c' should show the appropriate
 * parts of the General Public License.  Of course, your program's commands
 * might be different; for a GUI interface, you would use an "about box".
 *
 * You should also get your employer (if you work as a programmer) or school,
 * if any, to sign a "copyright disclaimer" for the program, if necessary.
 * For more information on this, and how to apply and follow the GNU GPL, see
 * <http://www.gnu.org/licenses/>.
 *
 * The GNU General Public License does not permit incorporating your program
 * into proprietary programs.  If your program is a subroutine library, you
 * may consider it more useful to permit linking proprietary applications with
 * the library.  If this is what you want to do, use the GNU Lesser General
 * Public License instead of this License.  But first, please read
 * <http://www.gnu.org/philosophy/why-not-lgpl.html>.
 */

package com.example.qiyue.imageloader.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.example.qiyue.imageloader.R;
import com.nostra13.universalimageloader.core.ImageLoader;



/**
 * @ Author: qiyue (ustory)
 * @ Email: qiyuekoon@foxmail.com
 * @ Data:2016/3/2
 */
public class GlideUtils {

    private static final String TAG = "GlideUtils";

    /**
     * 加载一个圆形图片
     */
    public static void displayCircle(ImageView view,String url){
        RequestManager requestManager = Glide.with(view.getContext());
        requestManager.load(url).transform(new GlideCircleTransform(view.getContext())).into(view);
    }
    /**
     * 加载一个自定义圆角图片
     * @param view
     * @param url
     * @param round 设置圆角
     */
    public static void displayRound(ImageView view,String url,int round){
        RequestManager requestManager = Glide.with(view.getContext());
        requestManager.load(url).transform(new GlideRoundTransform(view.getContext(), round)).into(view);
    }

    /**
     * 无站位图，centerCrop策略加载
     * @param view
     * @param url
     */
    public static void displayCenterCrop(ImageView view,String url){
        Glide.with(view.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(view);
    }

    /**
     * 无站位图，fitCenter策略
     * @param view
     * @param url
     */
    public static void displayFitCenter(ImageView view,String url){
        Glide.with(view.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .fitCenter()
                .into(view);
    }
    /**
     * glide加载图片
     * @param view view
     * @param url  url
     */
    public static void display(ImageView view, String url) {
       // displayUrl(view, url, R.mipmap.icon_logo);
        displayUrl(view, url, R.mipmap.ic_launcher);
    }

    /***
     *
     * @param view
     * @param url
     * @param defaultImage
     */
    public static void display(ImageView view, String url, int defaultImage) {
        displayUrl(view, url, defaultImage);
    }


    private static void displayUrl(final ImageView view, String url, @DrawableRes int defaultImage) {
        // 不能崩
        if (view == null) {
            L.e("GlideUtils -> display -> imageView is null");
            return;
        }
        Context context = view.getContext();
        // View你还活着吗？
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }

        try {
            L.i("displayUrl="+url);
            Glide.with(context)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(defaultImage)
                    .crossFade()
                    .centerCrop()
                    .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void displayNative(final ImageView view, @DrawableRes int resId) {
        // 不能崩
        if (view == null) {
            L.e("GlideUtils -> display -> imageView is null");
            return;
        }
        Context context = view.getContext();
        // View你还活着吗？
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }

        try {
            Glide.with(context)
                    .load(resId)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .centerCrop()
                    .into(view).getSize(new SizeReadyCallback() {
                @Override
                public void onSizeReady(int width, int height) {
                    L.i("Glide-loadNativeImage-width=" + width + "height=" + height);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayResolveBug(final ImageView imageView, String url){


    }






}
