package cn.fq.feihuoboost.base

import android.app.Application
import cn.fq.feihuoboost.constant.KeyConstants
import cn.fq.feihuoboost.delegate.NotNullSingleValueVar
import cn.wopaipai.tool.LogTool
import com.tencent.stat.MtaSDkException
import com.tencent.stat.StatConfig
import com.tencent.stat.StatService

/**
 *
 * @projectName: FHBoost
 * @packageName: cn.fq.feihuoboost.base
 * @author:      catherine
 * @time:        2020-02-05
 *
 */
class BaseApplication : Application() {
    private val TAG = BaseApplication::class.java.simpleName

    companion object {
        /**声明可控的对象*/
        private var instance: BaseApplication by NotNullSingleValueVar()

        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        configTENCENTMobileAnalysis()

    }

    /**
     * 配置腾讯移动分析
     * */
    private fun configTENCENTMobileAnalysis() {
        // 打开Logcat输出，上线时，一定要关闭
        StatConfig.setDebugEnable(true)
        StatConfig.setInstallChannel(instance(), "yingyongbao")
        // 注册activity生命周期，统计时长
        StatService.registerActivityLifecycleCallbacks(instance())
        // 初始化并启动MTA
        try {
            // 第三个参数必须为：com.tencent.stat.common.StatConstants.VERSION
            StatService.startStatService(
                this, KeyConstants.TENCENT_APP_KEY,
                com.tencent.stat.common.StatConstants.VERSION
            );
            LogTool.d(TAG, "MTA初始化成功")
        } catch (e: MtaSDkException) {
            // MTA初始化失败
            LogTool.d(TAG, "MTA初始化失败" + e)
        }

    }
}