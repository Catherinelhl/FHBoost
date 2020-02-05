package cn.fq.feihuoboost.base

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import cn.fq.feihuoboost.constant.KeyConstants

/**
 *
 * @projectName: FHBoost
 * @packageName: cn.fq.feihuoboost.base
 * @author:      catherine
 * @time:        2020-02-05
 * @description: Activity基类
 *
 */
abstract class BaseActivity : BaseRequestPermissionActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            getArgs(it)
        }
        setContentView(getContentView())
        initView()
        initListener()
    }

    abstract fun getArgs(bundle: Bundle)
    abstract fun getContentView():Int
    abstract fun initView()
    abstract fun initListener()

}