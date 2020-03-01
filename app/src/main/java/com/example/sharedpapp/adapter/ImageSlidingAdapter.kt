package com.example.sharedpapp.adapter

import android.view.View
import androidx.viewpager.widget.PagerAdapter
import android.os.Parcelable
import android.content.Context
import android.media.Image
import android.view.ViewGroup
import java.nio.file.Files.size
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.sharedpapp.R
import kotlinx.android.synthetic.main.fragment_detail.view.*


class ImageSlidingAdapter( private val context:Context): PagerAdapter() {

    private var layoutInflater:LayoutInflater?=null
    private val images = arrayOf(R.drawable.ic_account_circle_black_24dp,R.drawable.ic_home, R.drawable.ic_account_circle_black_24dp)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater!!.inflate(R.layout.fragment_detail,null)

        val imgDetail = view.findViewById<ImageView>(R.id.image_slider)
        imgDetail.setImageResource(images[position])

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