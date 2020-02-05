package cn.fq.feihuoboost.activity

import android.content.pm.PackageManager
import android.os.Bundle
import cn.fq.feihuoboost.R
import cn.fq.feihuoboost.base.BaseActivity
import cn.fq.feihuoboost.constant.KeyConstants
import cn.wopaipai.tool.LogTool
import com.tencent.stat.StatService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity() {

    private val TAG = MainActivity::class.java.simpleName
    override fun getArgs(bundle: Bundle) {
    }

    override fun getContentView(): Int = R.layout.activity_main

    override fun initView() {
        requestPermission()
    }



    override fun initListener() {
        tv_dot.setOnClickListener {
            // 统计按钮被点击次数，统计对象：OK按钮
            val prop = Properties()
            prop.setProperty("name", "Dot me...")
            StatService.trackCustomKVEvent(this, "button_click", prop)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val prop = Properties()
        prop.setProperty("close_app",  "${System.currentTimeMillis()}")
        StatService.trackCustomBeginKVEvent(this, "app_time", prop)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            KeyConstants.REQUEST_READ_PHONE_STATE ->
                if ((grantResults.isNotEmpty())
                    && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    LogTool.d(TAG,"REQUEST_READ_PHONE_STATE")
                    val prop = Properties()
                    prop.setProperty("open_app","${System.currentTimeMillis()}")
                    StatService.trackCustomBeginKVEvent(this, "app_time", prop)
                   }
            else->{}
        }
    }

}
