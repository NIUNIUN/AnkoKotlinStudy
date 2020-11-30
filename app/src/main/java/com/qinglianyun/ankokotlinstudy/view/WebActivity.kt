package com.qinglianyun.ankokotlinstudy.view

import android.support.v7.widget.Toolbar
import android.webkit.WebView
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.base.BaseActivity
import com.qinglianyun.ankokotlinstudy.presenter.MainPresnter
import com.qinglianyun.ankokotlinstudy.view.iview.IMainView

/**
 * Created by tang_xqing on 2019/11/7.
 */
class WebActivity : BaseActivity<IMainView, MainPresnter>(), IMainView {
    private lateinit var mWvWeb: WebView
    private lateinit var mToolbar: Toolbar

    override fun getLayoutView(): Int {
        return R.layout.activity_web
    }

    override fun initPresenter() {
        mPresenter = MainPresnter(this)
    }

    override fun initViews() {
        mWvWeb = findViewById(R.id.wv_web)
        mToolbar = findViewById(R.id.tl_web)
        with(mWvWeb.settings) {
            javaScriptEnabled = true    // 支持加载javaScript
            loadsImagesAutomatically = true     // 自动加载图片
            useWideViewPort = true      // 将图片调整到合适大小
            loadWithOverviewMode = true // 缩放至屏幕的大小
        }
    }

    override fun initListeners() {
    }

    override fun initData() {
        val loadUrl = intent.extras.getString(WEB_LOAD_URL)
        val loadTitle = intent.extras.getString(WEB_LOAD_TITLE)
        mToolbar.setTitle(loadTitle)
        mWvWeb.loadUrl(loadUrl)
    }

    companion object {
        val WEB_LOAD_URL = "load_url"
        val WEB_LOAD_TITLE = "load_title"
    }
}