package com.harpreetayali.day61task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.harpreetayali.day61task.ViewModels.LoginViewModel
import com.harpreetayali.day61task.ViewModels.UserListViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        btn_log_in.setOnClickListener {
            val model = ViewModelProvider(this).get(LoginViewModel::class.java)
            model.getLoginResult(et_email_login.text.toString(),et_password_login.text.toString()).observe(this,
                Observer {
//                    Toast.makeText(this,"Result : ${it.error}",Toast.LENGTH_LONG).show()
                })
        }

    }
}