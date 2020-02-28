package com.example.sharedpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.app.Fragment
import android.app.FragmentTransaction
import com.example.sharedpapp.fragment.AccountFragment
import com.example.sharedpapp.fragment.ImageFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var menu : Menu = bottomView.menu
        selectedMenu(menu.getItem(0))

        bottomView.setOnNavigationItemSelectedListener {
            item : MenuItem -> selectedMenu(item)

            false
        }

    }

    private fun selectedMenu(item: MenuItem){
        item.isChecked = true
        when(item.itemId){
            R.id.homeMenu -> selectedFragment(ImageFragment.newInstance())
            R.id.profileMenu -> selectedFragment(AccountFragment.newInstance())
        }
    }

    fun selectedFragment(fragment: Fragment){
        var transaction : FragmentTransaction = fragmentManager.beginTransaction()
        transaction?.replace(R.id.rootFragment, fragment)
        transaction?.commit()
    }
}
