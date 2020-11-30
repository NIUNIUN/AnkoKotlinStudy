package com.qinglianyun.ankokotlinstudy.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.adapter.CommAdapter
import com.qinglianyun.ankokotlinstudy.base.BaseFragment
import com.qinglianyun.ankokotlinstudy.bean.CommomData
import com.qinglianyun.ankokotlinstudy.presenter.CommTabPresenter
import com.qinglianyun.ankokotlinstudy.view.iview.ICommTabView

/**
 * Created by tang_xqing on 2019/11/6.
 */
class CommTabFragmentIos : BaseFragment<ICommTabView, CommTabPresenter>(), ICommTabView {
    private val TAG: String = CommTabFragmentIos::class.java.simpleName
    private lateinit var mRvCommom: RecyclerView
    private lateinit var mSwrlComm: SwipeRefreshLayout
    private lateinit var mAdapter: CommAdapter
    private var mListData: MutableList<CommomData> = mutableListOf()

    private val mPage: Int = 1
    private val mNumber: Int = 20
    private lateinit var mType: String

    override fun getLayoutId(): Int {
        /*with(arguments) {
            this?.getString(TAB_TYPE_KEY).let {
                mType = when (it) {
                    TAB_TYPE_VALUE_ANDROID -> "Android"
                    TAB_TYPE_VALUE_IOS -> "iOS"
                    TAB_TYPE_VALUE_WEB -> "前端"
                    else -> "Android"
                }
            }
        }*/

        /*val layoutId = when (mType) {
            TAB_TYPE_VALUE_ANDROID -> R.layout.fragment_home_android
            TAB_TYPE_VALUE_IOS -> R.layout.fragment_home_ios
            TAB_TYPE_VALUE_WEB -> R.layout.fragment_home_web
            else -> R.layout.fragment_home_android
        }*/

//        val layoutId = R.layout.fragment_home_android

//        return layoutId


        mType = "iOS"
        return R.layout.fragment_home_ios
    }

    override fun initPresenter() {
        mPresenter = CommTabPresenter(this)
    }

    override fun initViews() {
        mRvCommom = mActivity.findViewById<RecyclerView>(R.id.rv_commom_data_ios)
        mSwrlComm = mActivity.findViewById(R.id.srl_commom_ios)
        mAdapter = CommAdapter(mActivity, mListData)
    }

    override fun initData() {
        mSwrlComm.setColorSchemeResources(R.color.comm_green_38b487)
        mRvCommom.layoutManager = LinearLayoutManager(mActivity)
        mRvCommom.addItemDecoration(DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL))

        mRvCommom.adapter = mAdapter

        mPresenter?.getData(mType, mNumber, mPage)
        mSwrlComm.isRefreshing = true
    }

    override fun initListeners() {
        mAdapter.setOnItemClickListener { adapter, view, position ->
            var commomData: CommomData = mAdapter.getItem(position) as CommomData
            commomData.url
            commomData.let {
                mActivity.startActivity(
                        Intent().apply {
                            putExtra(WebActivity.WEB_LOAD_TITLE, commomData.source)
                            putExtra(WebActivity.WEB_LOAD_URL, commomData.url)
                            setClass(mActivity, WebActivity::class.java)
                        })
            }
        }

        // 非lambda表达式，
        /* mSwrlComm.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
             override fun onRefresh() {
                 Toast.makeText(mActivity, "刷新中", Toast.LENGTH_SHORT).show()
             }
         })*/

        // lambda函数表达式，只适用于接口只有一个回调函数
        mSwrlComm.setOnRefreshListener({
            mPresenter?.getData(mType, mNumber, mPage)
        })
    }

    override fun getDataFailed(message: String) {
        this.mSwrlComm.isRefreshing = false
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun getDataSuccess(mData: MutableList<CommomData>) {
        this.mSwrlComm.isRefreshing = false
        if (!mData.isEmpty()) {
            mAdapter.setNewData(mData)
        }
    }

    /**
     * 伴生对象，类似静态代码
     * 伴生属性、伴生方法：相当于java中的静态属性、静态方法
     */
    companion object {
        const val TAB_TYPE_KEY = "tab_type"
        const val TAB_TYPE_VALUE_ANDROID = "Android"
        const val TAB_TYPE_VALUE_IOS = "iOS"
        const val TAB_TYPE_VALUE_WEB = "前端"

        //        fun newInstance(type: String) = CommTabFragmentIos().apply {
//            var bundle = Bundle()
//            bundle.putString(TAB_TYPE_KEY, type)
//            this.arguments = bundle
//        }
        fun newInstance() = CommTabFragmentIos()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPause() {
        Log.d(TAG, "onPause mType=$mType")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop mType=$mType")
        super.onStop()
    }

    override fun onResume() {
        Log.d(TAG, "onResume mType=$mType")
        super.onResume()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView mType=$mType")
        super.onDestroyView()
    }
}