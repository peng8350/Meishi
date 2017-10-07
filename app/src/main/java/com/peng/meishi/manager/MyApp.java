/*
 * this is Mr.Liang.author is 尐鹏,Android developer,
 * Hobby is play game,like War3,more and more.
 * will join into the github in the future
 */

package com.peng.meishi.manager;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.stetho.Stetho;
import com.orm.SugarContext;
import com.zhy.http.okhttp.OkHttpUtils;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by peng on 16-10-7.
 */
public class MyApp extends Application {

	private static Context context;

	public static Context getInstance() {
		return context;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		SugarContext.init(getInstance());
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				// .addInterceptor(new LoggerInterceptor("TAG"))
				.connectTimeout(10000L, TimeUnit.MILLISECONDS)
				.readTimeout(10000L, TimeUnit.MILLISECONDS)
				// 其他配置
				.build();
		OkHttpUtils.initClient(okHttpClient);
		 OkHttpNetworkFetcher myNetworkFetcher = new
				 OkHttpNetworkFetcher(okHttpClient);

		ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
				.setNetworkFetcher(myNetworkFetcher)
				.setBitmapsConfig(Bitmap.Config.RGB_565)
				.setResizeAndRotateEnabledForNetwork(true)
				.setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
				.build();
		Fresco.initialize(this, config);
		Stetho.initialize(Stetho
				.newInitializerBuilder(this)
				.enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
				.enableWebKitInspector(
						Stetho.defaultInspectorModulesProvider(this)).build());
	}
}
