package com.qinglianyun.ankokotlinstudy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.bean.CommomData

/**
 * Created by tang_xqing on 2019/11/7.
 */
class PicatureAdapter(val ctx: Context, data: MutableList<CommomData>) : BaseQuickAdapter<CommomData, BaseViewHolder>(data) {
    override fun onCreateDefViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        var view = LayoutInflater.from(ctx).inflate(R.layout.item_picature_layout, parent, false)
        return BaseViewHolder(view)
    }

    override fun convert(helper: BaseViewHolder?, item: CommomData?) {
        helper?.apply {
            item?.apply {
                val girlImg = helper.getView<ImageView>(R.id.img_picature)
                Glide.with(ctx)
                        .load(item.url)
                        .asBitmap()
                        .placeholder(R.color.comm_green_38b487)
                        .error(R.color.comm_black)
                        .into(girlImg)
                setText(R.id.tv_picature_time, item?.createdAt.substring(0, 10))
                addOnClickListener(R.id.tv_picature_time)
            }
        }
    }
}