package com.qinglianyun.ankokotlinstudy.view.iview

import com.qinglianyun.ankokotlinstudy.base.IBaseView
import com.qinglianyun.ankokotlinstudy.bean.CommomData

/**
 * Created by tang_xqing on 2019/11/7.
 */
interface ICommTabView :IBaseView{
    fun getDataSuccess(mData : MutableList<CommomData>)

    fun getDataFailed(message : String)
}