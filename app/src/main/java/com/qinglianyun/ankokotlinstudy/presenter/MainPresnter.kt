package com.qinglianyun.ankokotlinstudy.presenter

import com.qinglianyun.ankokotlinstudy.base.BasePresenter
import com.qinglianyun.ankokotlinstudy.module.MainModel
import com.qinglianyun.ankokotlinstudy.view.iview.IMainView

/**
 * Created by tang_xqing on 2019/11/6.
 */
class MainPresnter(view: IMainView) : BasePresenter<IMainView>(view) {
    lateinit var mModel: MainModel

    init {
        mModel = MainModel()
    }

    fun getData(tyoe: String, number: Int, page: Int) {

    }
}