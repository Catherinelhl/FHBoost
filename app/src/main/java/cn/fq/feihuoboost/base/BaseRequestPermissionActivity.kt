package cn.fq.feihuoboost.base

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import cn.fq.feihuoboost.constant.KeyConstants
import cn.fq.feihuoboost.constant.KeyConstants.REQUEST_READ_PHONE_STATE

/**
 *
 * @projectName: FHBoost
 * @packageName: cn.fq.feihuoboost.base
 * @author:      catherine
 * @time:        2020-02-05
 * @description:
 *
 */
abstract class BaseRequestPermissionActivity :AppCompatActivity(),
    ActivityCompat.OnRequestPermissionsResultCallback {

    fun requestPermission(){
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,  arrayOf(Manifest.permission.READ_PHONE_STATE), REQUEST_READ_PHONE_STATE)
        } else {
            //TODO
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            REQUEST_READ_PHONE_STATE ->
                if ((grantResults.isNotEmpty())
                    && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                }
            else->{}
        }
    }

}