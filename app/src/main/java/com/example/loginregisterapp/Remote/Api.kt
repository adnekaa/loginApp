package com.example.loginregisterapp.Remote

import com.example.loginregisterapp.model.RootObject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username")username:String,
        @Field("password")password:String
    ):Call<RootObject>
}