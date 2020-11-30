package com.qinglianyun.ankokotlinstudy.presenter

import android.util.Log
import com.qinglianyun.ankokotlinstudy.base.BasePresenter
import com.qinglianyun.ankokotlinstudy.bean.BaseBean
import com.qinglianyun.ankokotlinstudy.bean.CommomData
import com.qinglianyun.ankokotlinstudy.module.MainModel
import com.qinglianyun.ankokotlinstudy.utils.HttpAPi
import com.qinglianyun.ankokotlinstudy.view.iview.ICommTabView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by tang_xqing on 2019/11/7.
 */
class CommTabPresenter(view: ICommTabView) : BasePresenter<ICommTabView>(view) {

    val mModel: MainModel by lazy {
        MainModel()
    }

    fun getData(type: String, number: Int, page: Int) {
        Log.d("接口请求 ", "type = $type")

        HttpAPi.apiServeice?.run {
            getGankData(type, number, page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    //                    .subscribe(object : Consumer<BaseBean<MutableList<CommomData>>> {
                    //                        override fun accept(t: BaseBean<MutableList<CommomData>>) {
                    //                            baseView?.getDataSuccess(t.results)
                    //                        }
                    //
                    //                    }, object : Consumer<Throwable> {
                    //                        override fun accept(t: Throwable) {
                    //                            baseView?.getDataFailed(t?.message ?: "")
                    //                        }
                    //                    })
                    .subscribe(
                            { success -> baseView?.getDataSuccess(success.results) },
                            { fail -> baseView?.getDataFailed(fail?.message ?: "") })
        }
    }

    fun getReq() {
        var listReq = HttpAPi.apiServeice?.listReq()

        // 异步请求
        listReq?.enqueue(object : Callback<BaseBean<MutableList<CommomData>>> {
            override fun onFailure(call: Call<BaseBean<MutableList<CommomData>>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<BaseBean<MutableList<CommomData>>>?, response: Response<BaseBean<MutableList<CommomData>>>?) {
                var error = response?.body()?.error
                var results = response?.body()?.results
            }

        })
        // 同步请求
        var execute = listReq?.execute()

    }
}