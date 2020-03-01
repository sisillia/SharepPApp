package com.example.sharedpapp.adapter

import android.view.View
import androidx.viewpager.widget.PagerAdapter
import android.os.Parcelable
import android.content.Context
import android.content.Intent
import android.media.Image
import android.util.Log
import android.view.ViewGroup
import java.nio.file.Files.size
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.sharedpapp.R
import kotlinx.android.synthetic.main.fragment_detail.view.*
import android.app.Activity




class ImageSlidingAdapter( private val context:Context): PagerAdapter() {

    companion object {
        const val EXTRA_POSITION = "extra_position"
    }

    private var layoutInflater:LayoutInflater?=null
    private val images = arrayOf(R.drawable.cat1,R.drawable.cat2, R.drawable.cat3)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater!!.inflate(R.layout.fragment_detail,null)

        val intent = (context as Activity).intent
        val positionDetail = intent.getIntExtra(EXTRA_POSITION,0)

        val imgDetail = view.findViewById<ImageView>(R.id.image_slider)
        imgDetail.setImageResource(images[positionDetail])
        val viewPager = container as ViewPager
        viewPager.addView(view,0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }


}