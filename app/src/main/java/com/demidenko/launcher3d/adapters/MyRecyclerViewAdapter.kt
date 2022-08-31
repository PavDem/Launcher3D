package com.demidenko.launcher3d.adapters

import android.app.Activity
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demidenko.launcher3d.R
import com.demidenko.launcher3d.appsList
import com.demidenko.launcher3d.loadApps
import com.demidenko.launcher3d.model.AppInfo

class MyRecyclerViewAdapter(
    private val activity: Activity,
    private val clickListener: (AppInfo) -> Unit,
) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyAppViewHolder>() {

    private val appsListDisplayed: MutableList<AppInfo>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAppViewHolder {
        val itemView = MyAppViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        ) {
            clickListener(appsListDisplayed[it])
        }
        return itemView
    }

    override fun onBindViewHolder(holder: MyAppViewHolder, position: Int) {
        val currentItem = appsListDisplayed[position]
        holder.label.text = currentItem.label
        holder.icon.setImageDrawable(currentItem.icon)
        holder.iconGeneric.setImageDrawable(currentItem.iconGeneric)

    }

    override fun getItemCount(): Int {
        return appsListDisplayed.size
    }

    init {
        // Load the apps
        if (appsList.size == 0)
            loadApps(activity.packageManager)
        else {
            AsyncTask.execute { loadApps(activity.packageManager) }
            notifyDataSetChanged()
        }

        appsListDisplayed = ArrayList()
        appsListDisplayed.addAll(appsList)
    }


    inner class MyAppViewHolder(itemView: View, clickAtPosition: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val label: TextView = itemView.findViewById(R.id.item_app_label)
        val icon: ImageView = itemView.findViewById(R.id.item_app_icon)

        //replace with actual generic icon
        val iconGeneric: ImageView = itemView.findViewById(R.id.icon_second)

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }
    }

}