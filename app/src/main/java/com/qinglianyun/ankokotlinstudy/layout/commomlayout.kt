package com.qinglianyun.ankokotlinstudy.layout

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.view.CommTabFragment
import org.jetbrains.anko.*

/**
 * Created by tang_xqing on 2019/11/11.
 */

class Commomlayout<T: AppCompatActivity> {
    fun createLayout(ui: AnkoContext<T>, context: Context) =
            ui?.run {
                verticalLayout {
                    orientation = LinearLayout.HORIZONTAL
                    button {
                        width = 80
                        height = 40
                        text = "点击"
                        background = context.getDrawable(R.color.comm_green_38b487)
                        textColor = context.getColor(R.color.comm_white)
                    }

                    editText {
                        hint = "提示输入名称"
                    }

                }
            }
}