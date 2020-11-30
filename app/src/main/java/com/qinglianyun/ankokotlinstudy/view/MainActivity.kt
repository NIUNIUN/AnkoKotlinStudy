package com.qinglianyun.ankokotlinstudy.view

import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.qinglianyun.ankokotlinstudy.R
import com.qinglianyun.ankokotlinstudy.base.BaseActivity
import com.qinglianyun.ankokotlinstudy.presenter.MainPresnter
import com.qinglianyun.ankokotlinstudy.view.iview.IMainView

class MainActivity : BaseActivity<IMainView, MainPresnter>(), IMainView {

    private lateinit var bnavMain: BottomNavigationView

    override fun getLayoutView(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter() {
        mPresenter = MainPresnter(this)
    }

    override fun initViews() {
        bnavMain = findViewById<BottomNavigationView>(R.id.bnv_main)
        // API 28之前通过反射设置。
//        BottomNavigationViewUtils.disableShiftMode(bnavMain)
    }

    override fun initListeners() {
        bnavMain.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.main_item_home -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fl_main, HomeFragment.newInstance()).commit()
                    }

                    R.id.main_item_picature -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fl_main, PicatureFragment.newInstance()).commit()
                    }
                    R.id.main_item_video -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fl_main, VideoFragment.newInstance()).commit()
                    }
                    R.id.main_item_mime -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fl_main, MimeFragment.newInstance()).commit()
                    }
                }

                return true
            }
        })
    }

    override fun initData() {
        supportFragmentManager.beginTransaction().replace(R.id.fl_main, HomeFragment.newInstance()).commit()
    }

}
