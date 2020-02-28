package com.example.sharedpapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.app.Fragment
import android.media.Image
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedpapp.ImageModel
import com.example.sharedpapp.R
import com.example.sharedpapp.adapter.ImageAdapter
import kotlinx.android.synthetic.main.fragment_image.*

class ImageFragment : Fragment() {

    private val list = ArrayList<ImageModel>()
    private lateinit var rv_img : RecyclerView

    companion object{
        fun newInstance() : ImageFragment = ImageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_image, container, false)

        rv_img = view.findViewById(R.id.recycler_image)

        list.addAll(getListImage())
        showRecyclerList()

        return view
    }

    fun getListImage(): ArrayList<ImageModel>{
        val dataImg = resources.getStringArray(R.array.image_movie)

        val listImg = ArrayList<ImageModel>()
        for (position in dataImg.indices){
            val img = ImageModel(dataImg[position])
            listImg.add(img)
        }
        return listImg
    }

    private fun showRecyclerList() {
        rv_img.setHasFixedSize(true)
        rv_img.layoutManager = LinearLayoutManager(activity)
        val listHeroAdapter = ImageAdapter(list)
        rv_img.adapter = listHeroAdapter
    }

}