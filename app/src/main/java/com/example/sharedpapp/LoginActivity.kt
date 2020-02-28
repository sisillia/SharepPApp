package com.example.sharedpapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : Activity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        bt_submit.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.bt_submit -> {
                if(edt_password.text.toString().isEmpty()){
                    edt_password.setError("This field can not be blank")
                } else if(edt_email.text.toString().isEmpty()){
                    edt_email.setError("This field can not be blank")
                } else{
                    val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
                    var editor = sharedPreference.edit()
                    editor.putString("username",edt_email.text.toString())
                    editor.putString("password",edt_password.text.toString())
                    editor.commit()

                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

}

