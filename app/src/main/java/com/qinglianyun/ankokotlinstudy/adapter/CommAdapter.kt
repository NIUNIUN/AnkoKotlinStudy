package com.qinglianyun.ankokotlinstudy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.bean.CommomData

/**
 * Created by tang_xqing on 2019/11/6.
 */
class CommAdapter(val context: Context, data: MutableList<CommomData>?) : BaseQuickAdapter<CommomData, BaseViewHolder>(data) {

    override fun onCreateDefViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        var inflate: View = LayoutInflater.from(context).inflate(R.layout.item_home_comm_tab, parent, false)
        return BaseViewHolder(inflate)
    }

    override fun convert(helper: BaseViewHolder?, item: CommomData?) {
//        helper?.let {
//            it.setText(R.id.tv_name, item?.who)
//        }

        /**
         * 高阶函数：apply函数返回对象本身，与run函数类型。
         * run函数：let函数与with函数结合体
         */
        helper?.apply {
            item?.apply {
                setText(R.id.tv_name, who)
                setText(R.id.tv_tab, type)
                setText(R.id.tv_title, desc)
                setText(R.id.tv_updatetime, createdAt.substring(0,10))
            }
        }
    }
}