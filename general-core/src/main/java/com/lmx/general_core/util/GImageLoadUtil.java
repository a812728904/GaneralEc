package com.lmx.general_core.util;

import android.content.Context;
import android.widget.ImageView;

import java.io.File;


/**
 * 基于Glide的 图片加载
 * 
 * @author LMX
 */
public class GImageLoadUtil {
	private static GImageLoadUtil gImageLoad;

	private GImageLoadUtil() {
	};

	private String imageUrl;

	public static GImageLoadUtil getImageLoad() {
		if (gImageLoad != null)
			return gImageLoad;
		gImageLoad = new GImageLoadUtil();
		return gImageLoad;
	}

	public void imageLoader(Context context, String imgurl,
							ImageView myImageView) {
		/*Glide.with(context).load(imgurl).placeholder(R.mipmap.ic_launcher)
				.crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
				.into(myImageView);*/
	}

	public void loadCircle(Context context, String imgurl,
								  ImageView myImageView) {
	/*	Glide.with(context).load(imgurl).placeholder(R.mipmap.ic_launcher)
				.crossFade()
				.transform(new GlideCircleTransform(context))
				.diskCacheStrategy(DiskCacheStrategy.ALL).into(myImageView);*/
	}
	public void loadResourceId(Context context, int resourceId,
							   ImageView myImageView){
	/*	Glide.with(context).load(resourceId).placeholder(R.mipmap.ic_launcher)
				.crossFade()
				.transform(new GlideCircleTransform(context))
				.diskCacheStrategy(DiskCacheStrategy.ALL).into(myImageView);*/
	}
	public void loadRound(Context context, String imgurl,
								 ImageView myImageView) {
		/*Glide.with(context).load(imgurl).placeholder(R.mipmap.ic_launcher)
				.crossFade().transform(new GlideRoundTransform(context, 4))
				.diskCacheStrategy(DiskCacheStrategy.ALL).into(myImageView);*/
	}

	public void loadFile(Context context, File fileImg,
								ImageView myImageView) {
		/*Glide.with(context).load(fileImg).placeholder(R.mipmap.ic_launcher)
				.transform(new GlideCircleTransform(context))
				.diskCacheStrategy(DiskCacheStrategy.ALL).into(myImageView);*/
	}

}
//.diskCacheStrategy(DiskCacheStrategy.NONE)禁止磁盘缓存
//.skipMemoryCache(true) 禁止内存缓存