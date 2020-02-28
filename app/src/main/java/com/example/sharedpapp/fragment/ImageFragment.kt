package com.example.sharedpapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.app.Fragment
import com.example.sharedpapp.R

class ImageFragment : Fragment() {

    companion object{
        fun newInstance() : ImageFragment = ImageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_image, container, false)

    }
}