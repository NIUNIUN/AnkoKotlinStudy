package com.qinglianyun.ankokotlinstudy.bean

/**
 * Created by tang_xqing on 2019/11/6.
 */
data class CommomData(val _id: String,
                      val createdAt: String,
                      val desc: String,
                      val images: Array<String>,
                      val publishedAt: String,
                      val source: String,
                      val type: String,
                      val url: String,
                      val used: Boolean,
                      val who: String) {
}