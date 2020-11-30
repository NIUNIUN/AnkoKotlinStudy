package com.qinglianyun.ankokotlinstudy.view

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.adapter.PicatureAdapter
import com.qinglianyun.ankokotlinstudy.base.BaseFragment
import com.qinglianyun.ankokotlinstudy.bean.CommomData
import com.qinglianyun.ankokotlinstudy.presenter.CommTabPresenter
import com.qinglianyun.ankokotlinstudy.view.iview.ICommTabView

/**
 * Created by tang_xqing on 2019/11/6.
 */
class PicatureFragment : BaseFragment<ICommTabView, CommTabPresenter>(), ICommTabView {
    private lateinit var mRvPicature: RecyclerView
    private lateinit var mSrlPicature: SwipeRefreshLayout

    private var mList: MutableList<CommomData> = mutableListOf()
    private lateinit var mAdapter: PicatureAdapter

    private val mPage: Int = 1
    private val mNumber: Int = 20

    override fun getLayoutId(): Int {
        return R.layout.fragment_picature
    }

    override fun initPresenter() {
        mPresenter = CommTabPresenter(this)
    }

    override fun initViews() {
        mRvPicature = mActivity.findViewById(R.id.rv_picature)
        mSrlPicature = mActivity.findViewById(R.id.srl_picature)
        mAdapter = PicatureAdapter(mActivity, mList)
        mSrlPicature.setColorSchemeResources(R.color.comm_green_38b487)
    }

    override fun initListeners() {
        mAdapter.setOnItemClickListener { adapter, view, position ->
            Toast.makeText(mActivity, "点击 position= " + position, Toast.LENGTH_SHORT).show()
        }
        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            Toast.makeText(mActivity, "点击子view position= " + position, Toast.LENGTH_SHORT).show()
        }

        mSrlPicature.setOnRefreshListener({
            mPresenter?.getData("福利", mNumber, mPage)
        })
    }

    override fun initData() {
        mRvPicature.adapter = mAdapter
        mRvPicature.layoutManager = GridLayoutManager(mActivity, 3)

        mPresenter?.getData("福利", mNumber, mPage)
        mSrlPicature.isRefreshing = true
    }

    companion object {
        fun newInstance() = PicatureFragment()
    }

    override fun getDataFailed(message: String) {
        this.mSrlPicature.isRefreshing = false
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun getDataSuccess(mData: MutableList<CommomData>) {
        this.mSrlPicature.isRefreshing = false
        if (!mData.isEmpty()) {
            mAdapter.setNewData(mData)
        }
    }
}