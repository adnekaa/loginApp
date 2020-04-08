package com.example.loginregisterapp.storage

import android.content.SharedPreferences;
import android.content.Context
import com.example.loginregisterapp.model.Result_object
/*
data class Result_object ( val issued:String, val expires:String)
 */


class SharedPrefManager private constructor(private val mCtx: Context) {
    val user: Result_object
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(Companion.SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return Result_object(
                sharedPreferences.getString("access_token", null).toString(),
                sharedPreferences.getString("token_type", null).toString(),
                sharedPreferences.getString("refresh_token", null).toString(),
                sharedPreferences.getString("expires_in", null).toString(),
                sharedPreferences.getString("id", null).toString(),
                sharedPreferences.getString("email", null).toString(),
                sharedPreferences.getString("phone", null).toString(),
                sharedPreferences.getString("countryCode", null).toString(),
                sharedPreferences.getString("balance", null).toString(),
                sharedPreferences.getBoolean("isActive", true),
                sharedPreferences.getBoolean("isCustomer", true),
                sharedPreferences.getBoolean("isDelegate", true),
                sharedPreferences.getString("issued", null).toString(),
                sharedPreferences.getString("expires", null).toString()
            )
        }
    fun saveUser(user: Result_object) {
        val sharedPreferences = mCtx.getSharedPreferences(
            Companion.SHARED_PREF_NAME,
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString("access_token",user.access_token)
        editor.putString("token_type", user.token_type)
        editor.putString("refresh_token", user.refresh_token)
        editor.putString("expires_in", user.expires_in)
        editor.putString("id", user.id)
        editor.putString("email", user.email)
        editor.putString("phone", user.phone)
        editor.putString("countryCode", user.countryCode)
        editor.putString("balance", user.balance)
        editor.putBoolean("isActive",user.isActive)
        editor.putBoolean("isCustomer",user.isCustomer)
        editor.putBoolean("isDelegate",user.isDelegate)
        editor.putString("issued", user.issued)
        editor.putString("expires", user.expires)
        editor.apply()
    }

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(
                Companion.SHARED_PREF_NAME,
                Context.MODE_PRIVATE
            )
            return sharedPreferences.getInt("id", -1) != -1
        }



    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(
            Companion.SHARED_PREF_NAME,
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {

        private var mInstance: SharedPrefManager? = null

        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager? {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }

        private const val SHARED_PREF_NAME = "my_shared_preff"
    }

}