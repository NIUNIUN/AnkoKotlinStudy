package com.qinglianyun.ankokotlinstudy.view

import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.base.BaseFragment
import com.qinglianyun.ankokotlinstudy.base.IBaseView
import com.qinglianyun.ankokotlinstudy.presenter.MainPresnter
import com.qinglianyun.ankokotlinstudy.view.iview.IMainView

/**
 * Created by tang_xqing on 2019/11/6.
 */
class VideoFragment : BaseFragment<IMainView, MainPresnter>(), IBaseView {
    override fun getLayoutId(): Int {
        return R.layout.fragment_video
    }

    override fun initPresenter() {
    }

    override fun initViews() {
    }

    override fun initListeners() {
    }

    override fun initData() {
    }

    companion object {
        fun newInstance() = VideoFragment()
    }
}