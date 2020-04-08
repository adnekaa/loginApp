package com.example.loginregisterapp.Remote

import android.util.Base64
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    public var username:String=""
    public var password:String=""


    private const val BASE_URL = "https://camion-ksa.com/devenv/api/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .method(original.method(), original.body())
            val mediaType=MediaType.parse("application/x-www-form-urlencoded,application/x-www-form-urlencoded")
            val body= RequestBody.create(mediaType, "username="+username+"&password="+password);

            val request = requestBuilder
                .url("https://camion-ksa.com/devenv/api/login")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build()
            chain.proceed(request)
        }.build()

    val instance: Api by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }

}