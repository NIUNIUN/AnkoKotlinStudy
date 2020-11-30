package com.qinglianyun.ankokotlinstudy.view

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.base.BaseFragment
import com.qinglianyun.ankokotlinstudy.base.IBaseView
import com.qinglianyun.ankokotlinstudy.presenter.MainPresnter
import com.qinglianyun.ankokotlinstudy.view.iview.IMainView

/**
 * Created by tang_xqing on 2019/11/6.
 */
class HomeFragment : BaseFragment<IMainView, MainPresnter>(), IBaseView {
    private val TAG: String = HomeFragment::class.java.simpleName
    private lateinit var mTabHome: TabLayout
    private lateinit var mVpHome: ViewPager
    private var mFragmentList: MutableList<Fragment> = mutableListOf()

    val tabTitle: Array<String> by lazy {
        arrayOf(mActivity.getString(R.string.home_android),
                mActivity.getString(R.string.home_ios),
                mActivity.getString(R.string.home_h5))
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initPresenter() {
    }

    override fun initViews() {
        mTabHome = mActivity.findViewById<TabLayout>(R.id.tab_home)
        mVpHome = mActivity.findViewById<ViewPager>(R.id.vp_home)
    }

    override fun initListeners() {
    }

    override fun initData() {
        mVpHome.adapter = object : FragmentPagerAdapter(childFragmentManager) {
            override fun getItem(position: Int): Fragment {
                Log.d(TAG, "getItem position = $position")
                return mFragmentList[position]
            }

            override fun getCount(): Int {
                Log.d(TAG, "getCount size = ${mFragmentList.size}")
                return mFragmentList.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                Log.d(TAG, "getPageTitle position = $position")
                return tabTitle[position]
            }
        }
        mTabHome.setupWithViewPager(mVpHome)
        mFragmentList.add(CommTabFragment.newInstance())
        mFragmentList.add(CommTabFragmentIos.newInstance())
        mFragmentList.add(CommTabFragmentWeb.newInstance())
//        mFragmentList.add(CommTabFragment.newInstance(CommTabFragment.TAB_TYPE_VALUE_ANDROID))
//        mFragmentList.add(CommTabFragmentIos.newInstance(CommTabFragmentIos.TAB_TYPE_VALUE_IOS))
//        mFragmentList.add(CommTabFragmentWeb.newInstance(CommTabFragmentWeb.TAB_TYPE_VALUE_WEB))
        (mVpHome.adapter as FragmentPagerAdapter).notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}