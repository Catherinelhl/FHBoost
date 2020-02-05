package cn.catherine.token.tool.json

import cn.fq.feihuoboost.constant.MessageConstants
import cn.wopaipai.tool.StringTool
import org.json.JSONException
import org.json.JSONObject



/**
 *
 * @projectName: FHBoost
 * @packageName: cn.fq.feihuoboost.base
 * @author:      catherine
 * @time:        2020-02-05
 * @description 工具類：JSON 数据判断
 */

object JsonTool {
    private val TAG = JsonTool::class.java.simpleName

    fun getString(resource: String, key: String): String {
        return getString(resource, key, MessageConstants.Empty)
    }

    fun getString(resource: String, key: String, value: String): String {
        return when {
            StringTool.isEmpty(resource) -> value
            StringTool.isEmpty(key) -> value
            else -> {
                var jsonObject: JSONObject? = null

                try {
                    jsonObject = JSONObject(resource)
                    if (!jsonObject.has(key)) value else jsonObject.getString(key)
                } catch (var5: JSONException) {
                    value
                }

            }
        }
    }


}