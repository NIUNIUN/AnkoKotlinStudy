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
class NavTestFragmentTwo : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("fragment", "创建 2")
        return inflater.inflate(R.layout.fragment_layout_test2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            var string = it.getString("bundle_data")
            Toast.makeText(activity, "接收到数据 " + string, Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.btn_click_two).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navTestFragmentTwo_to_mimeFragment2)
        }

        view.findViewById<TextView>(R.id.tv_test_two).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navTestFragmentTwo_to_textFragmentOne)
        }
    }
}