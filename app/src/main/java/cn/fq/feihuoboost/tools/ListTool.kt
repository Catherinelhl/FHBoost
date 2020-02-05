package cn.wopaipai.tool


/**
 *
 * @projectName: FHBoost
 * @packageName: cn.fq.feihuoboost.base
 * @author:      catherine
 * @time:        2020-02-05
 * @description 工具類：List內容管理
 */

object ListTool {
    //判断当前的list是否为空
    @JvmStatic
    fun <T> isEmpty(list: List<T>?): Boolean {
        if (list == null || list.isEmpty()) {
            return true
        }
        return false

    }

    @JvmStatic
    fun <T> noEmpty(list: List<T>?): Boolean {
        return !isEmpty(list)

    }

}