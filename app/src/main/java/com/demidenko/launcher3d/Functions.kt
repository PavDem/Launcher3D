package com.demidenko.launcher3d

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.Intent.getIntent
import android.content.pm.PackageManager
import android.widget.Toast
import com.demidenko.launcher3d.model.AppInfo

val appsList: MutableList<AppInfo> = ArrayList()

fun loadApps(packageManager: PackageManager) {
    val loadList = mutableListOf<AppInfo>()

    val i = Intent(Intent.ACTION_MAIN, null)
    i.addCategory(Intent.CATEGORY_LAUNCHER)
    val allApps = packageManager.queryIntentActivities(i, 0)
    for (ri in allApps) {
        val app = AppInfo()
        app.label = ri.loadLabel(packageManager)
        app.icon = ri.activityInfo.loadIcon(packageManager)
        app.iconGeneric = ri.activityInfo.loadIcon(packageManager)
        app.packageName = ri.activityInfo.packageName
        loadList.add(app)
    }
    loadList.sortBy { it.label.toString() }

    appsList.clear()
    appsList.addAll(loadList)
}

