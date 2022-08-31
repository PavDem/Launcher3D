package com.demidenko.launcher3d

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.demidenko.launcher3d.adapters.MyFragmentViewPagerAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AsyncTask.execute { loadApps(packageManager)}

        val pager = findViewById<ViewPager2>(R.id.viewpager)
        val adapter = MyFragmentViewPagerAdapter(this)
        val test = CustomPageTransformer()
        pager.adapter = adapter
        pager.setPageTransformer(test)

    }

    inner class CustomPageTransformer : ViewPager2.PageTransformer {
        //val test = CubeInTransformer()
        //val test2 = CubeOutTransformer()
        override fun transformPage(page: View, position: Float) {
            page.cameraDistance = (page.width * 20).toFloat()
            page.pivotX = if (position < 0f) page.width.toFloat() else 0f
            page.pivotY = page.height * 0.5f
            page.rotationY = 90f * position
        }
    }
}