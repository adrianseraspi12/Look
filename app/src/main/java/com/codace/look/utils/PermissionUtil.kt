package com.codace.look.utils

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

const val PERMISSION_GRANTED = 0
const val PERMISSION_NOT_GRANTED = -1
const val PERMISSION_NEVER_ASKED_AGAIN = -2
class PermissionUtil {

    companion object {

        //  Check if its permitted or not
        fun checkPermission(activity: Activity, permission: String): Int {
            if (ContextCompat.checkSelfPermission(activity.applicationContext, permission) !=
                PackageManager.PERMISSION_GRANTED) {

                if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    return PERMISSION_NEVER_ASKED_AGAIN
                }

                return PERMISSION_NOT_GRANTED

            } else {
                return PERMISSION_GRANTED
            }
        }

        //  request user for permission, it will show a dialog box
        fun requestPermission(activity: Activity, permission: String, requestCode: Int) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(permission),
                requestCode)
        }

    }

}
