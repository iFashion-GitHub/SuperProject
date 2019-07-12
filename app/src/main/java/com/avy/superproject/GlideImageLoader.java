package com.avy.superproject;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * 说明：
 * Created by leeqiuuu on 2019/7/9
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        imageView.setBackgroundResource((Integer) path);
    }

}