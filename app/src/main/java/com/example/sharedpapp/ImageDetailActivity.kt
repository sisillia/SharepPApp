package com.example.sharedpapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.sharedpapp.adapter.ImageSlidingAdapter
import kotlinx.android.synthetic.main.activity_image_detail.*
import com.facebook.stetho.inspector.elements.ShadowDocument.Update
import java.util.*


class ImageDetailActivity : AppCompatActivity() {

    private lateinit var mPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        mPager = findViewById(R.id.view_pager)
        val adapter = ImageSlidingAdapter(this)
        mPager.adapter = adapter

        indicator.setViewPager(mPager)

    }

}
