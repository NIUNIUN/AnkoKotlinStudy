package com.qinglianyun.ankokotlinstudy.view

import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.jetictors.welfare.view.widgets.GlideCircleTransform
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.base.BaseFragment
import com.qinglianyun.ankokotlinstudy.base.IBaseView
import com.qinglianyun.ankokotlinstudy.presenter.MainPresnter
import com.qinglianyun.ankokotlinstudy.view.iview.IMainView

/**
 * Created by tang_xqing on 2019/11/6.
 */
class MimeFragment : BaseFragment<IMainView, MainPresnter>(), IBaseView {
    private lateinit var mIvHead: ImageView
    private val mHeadUrl: String = "https://user-gold-cdn.xitu.io/2018/3/25/1625d7c5414004e0?imageView2/1/w/90/h/90/q/85/format/webp/interlace/1"
    private val mJuejinUrl: String = "https://juejin.im/user/5709f5798ac247004c295d95"
    private val mBlogUrl: String = "https://www.cnblogs.com/Jetictors/"
    private val mGithubUrl: String = "https://github.com/Jetictors"


    override fun getLayoutId(): Int {
        return R.layout.fragment_mime
    }

    override fun initPresenter() {
    }

    override fun initViews() {
        mIvHead = mActivity.findViewById(R.id.iv_head)
    }

    override fun initListeners() {
        mActivity.findViewById<TextView>(R.id.tv_juejin).setOnClickListener({
            mActivity.startActivity(Intent().apply{
                setClass(mActivity,WebActivity::class.java)
                putExtra(WebActivity.WEB_LOAD_URL,mJuejinUrl)
                putExtra(WebActivity.WEB_LOAD_TITLE,(it as TextView).text)
            })
        })

        mActivity.findViewById<TextView>(R.id.tv_juejin).setOnClickListener({
            mActivity.startActivity(Intent().apply{
                setClass(mActivity,WebActivity::class.java)
                putExtra(WebActivity.WEB_LOAD_URL,mBlogUrl)
                putExtra(WebActivity.WEB_LOAD_TITLE,(it as TextView).text)
            })
        })

        mActivity.findViewById<TextView>(R.id.tv_juejin).setOnClickListener({
            mActivity.startActivity(Intent().apply{
                setClass(mActivity,WebActivity::class.java)
                putExtra(WebActivity.WEB_LOAD_URL,mGithubUrl)
                putExtra(WebActivity.WEB_LOAD_TITLE,(it as TextView).text)
            })
        })

    }

    override fun initData() {
        Glide.with(mActivity)
                .load(mHeadUrl)
                .asBitmap()
                .centerCrop()
                .placeholder(R.drawable.ic_personal)
                .error(R.drawable.ic_personal)
                .transform(GlideCircleTransform(mActivity))
                .into(mIvHead)
    }

    companion object {
        fun newInstance() = MimeFragment()
    }
}