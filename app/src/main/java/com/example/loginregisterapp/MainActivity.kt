package com.example.loginregisterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.loginregisterapp.Remote.RetrofitClient
import com.example.loginregisterapp.databinding.ActivityMainBinding
import com.example.loginregisterapp.model.RootObject
import com.example.loginregisterapp.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding: ActivityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)
         binding.btnLogin.setOnClickListener {
             val username = binding.txtUser.text.toString()
             val password = binding.txtPassword.text.toString()
             RetrofitClient.username=username
             RetrofitClient.password=password
             RetrofitClient.instance.login(username, password)
                 .enqueue(object : Callback<RootObject>{
                     override fun onFailure(call: Call<RootObject>, t: Throwable) {
                         Toast.makeText(applicationContext,t.message, Toast.LENGTH_LONG).show()

                     }

                     override fun onResponse(call: Call<RootObject>, response: Response<RootObject>)
                     {
                        if(response.body()?.result_message.equals("Success.")){

                            SharedPrefManager.getInstance(applicationContext)?.saveUser(response.body()!!.result_object[0])
                            Toast.makeText(applicationContext,response.body()?.result_message, Toast.LENGTH_LONG).show()
                        }
                         else{
                            Toast.makeText(applicationContext,response.body()?.result_message, Toast.LENGTH_LONG).show()
                        }
                     }

                 }
           )
                     

                
         }



    }
}
