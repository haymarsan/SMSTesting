package com.haymarsan.smstesting.repository

import androidx.lifecycle.MutableLiveData
import com.haymarsan.smstesting.data.Token
import com.haymarsan.smstesting.network.RetrofitService
import com.haymarsan.smstesting.network.SmsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    lateinit var api: SmsApi


    init {
            api = RetrofitService().createService(SmsApi::class.java)
    }



    fun getOAuthToken(userName:String, password: String, grantType: String): MutableLiveData<Token>{

        var getToken = MutableLiveData<Token>()

        api.getToken(userName, password, grantType).enqueue(object : Callback<Token>{
            override fun onFailure(call: Call<Token>, t: Throwable) {

                getToken.value = null

            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                getToken.value = response.body()
            }

        })



        return getToken

    }

}