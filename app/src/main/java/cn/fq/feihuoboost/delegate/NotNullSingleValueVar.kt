package cn.fq.feihuoboost.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @projectName: FHBoost
 * @packageName: cn.fq.feihuoboost.delegate
 * @author:      catherine
 * @time:        2020-02-05
 * @description: 代理，防止单列为空
 * 定义一个属性管理类，进行非空和重复赋值的判断
 *
 */
class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("application not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("application already initialized")
    }
}