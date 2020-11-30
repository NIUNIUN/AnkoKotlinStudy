package com.qinglianyun.ankokotlinstudy.utils

import com.qinglianyun.ankokotlinstudy.bean.BaseBean
import com.qinglianyun.ankokotlinstudy.bean.CommomData
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by tang_xqing on 2019/11/7.
 */
interface GankService {
    @GET("data/{type}/{number}/{page}")
    fun getGankData(@Path("type")type:String,
                    @Path("number")number:Int,
                    @Path("page")page:Int): Flowable<BaseBean<MutableList<CommomData>>>

    @GET("data/{type}/{number}/{page}")
    fun listReq():Call<BaseBean<MutableList<CommomData>>>
}