package com.qinglianyun.ankokotlinstudy.bean

/**
 * Created by tang_xqing on 2019/11/7.
 */
class BaseBean<out T>(val error : Boolean, val results : T)