package com.qinglianyun.ankokotlinstudy.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.qinglianyun.ankokotlinstudy.R

/**
 * Created by tang_xqing on 2019/11/13.
 */
class NavTestFragmentFour : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        Toast.makeText(activity, "第一个Fragment", Toast.LENGTH_SHORT).show()
        Log.d("fragment", "创建 4")
        return inflater.inflate(R.layout.fragment_mime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var button = view.findViewById<Button>(R.id.btn_click_one)
//        button.setOnClickListener {
//
//            val bundle: Bundle = Bundle()
//            bundle.putString("bundle_data", "第一个fragment")
//
//            // 有参数跳转。两种方式：1、Bundle 2、safeargs 安全类型传递
//            Navigation.findNavController(button).navigate(R.id.action_navTestFragmentOne_to_navTestFragmentTwo, bundle)
//
//            // 无参数跳转
////            Navigation.findNavController(button).navigate(R.id.action_navTestFragmentOne_to_navTestFragmentTwo)
//        }
//
//        view.findViewById<TextView>(R.id.tv_test_one).setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_navTestFragmentOne_to_homeFragment3)
//        }
    }

}