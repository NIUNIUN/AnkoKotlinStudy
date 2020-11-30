package com.qinglianyun.ankokotlinstudy.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/** 静态类
 * Created by tang_xqing on 2019/11/7.
 */
object HttpAPi {
    private val BASE_URL = "http://gank.io/api/"
    private var mClient: OkHttpClient? = null
    private var mRetrofit: Retrofit? = null
    val apiServeice: GankService?by lazy {
        mRetrofit?.create(GankService::class.java)
    }

    init {
        val httpLogger = HttpLoggingInterceptor()
        httpLogger.level = HttpLoggingInterceptor.Level.BODY
        mClient = OkHttpClient.Builder()
                .addInterceptor(httpLogger)
                .connectTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .writeTimeout(30L, TimeUnit.SECONDS)
                .build()

        mClient?.run {
            mRetrofit = Retrofit.Builder()
                    .client(this)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
        }
    }

}