package com.qinglianyun.ankokotlinstudy.view

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.qinglianyun.ankokotlinstudy.R

/**
 * Created by tang_xqing on 2019/11/13.
 */
class NaviMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navi_main)
        initView()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // 使用此方法，Activity一片空白
//        setContentView(R.layout.activity_navi_main)
    }

    /**
     * 将back事件委托，若栈中存在两个fragment，那么就一个个出栈
     */
    override fun onSupportNavigateUp(): Boolean {
        var fragment = supportFragmentManager.findFragmentById(R.id.nav_main_host_fragment)
        return fragment!!.findNavController().navigateUp()
    }

    private fun initView() {

    }
}