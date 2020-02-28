package com.example.sharedpapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.app.Fragment
import com.example.sharedpapp.R

class AccountFragment : Fragment() {

    companion object{
        fun newInstance() : AccountFragment = AccountFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_account, container, false)

    }
}