package com.haymarsan.smstesting.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.haymarsan.smstesting.data.SMSResponse
import com.haymarsan.smstesting.data.SMSVO
import com.haymarsan.smstesting.data.TokenVO
import com.haymarsan.smstesting.network.RetrofitService
import com.haymarsan.smstesting.network.SmsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository{

    lateinit var api: SmsApi


    init {
            api = RetrofitService().createService(SmsApi::class.java)
    }



    fun getOAuthToken(userName:String, password: String, grantType: String): MutableLiveData<TokenVO>{

        var getToken = MutableLiveData<TokenVO>()

        api.getToken(userName, password, grantType).enqueue(object : Callback<TokenVO>{
            override fun onFailure(call: Call<TokenVO>, t: Throwable) {

                getToken.value = null

            }

            override fun onResponse(call: Call<TokenVO>, response: Response<TokenVO>) {
                getToken.value = response.body()
                Log.d("TokenVO", getToken.toString())
               // PreferenceUtils.saveData( context,"TokenVO", getToken)
            }

        })


        return getToken

    }


    fun getSMS(smsvo: SMSVO):MutableLiveData<SMSResponse>{

        var response = MutableLiveData<SMSResponse>()

        api.getSMS(smsvo).enqueue(object : Callback<SMSResponse>{
            override fun onFailure(call: Call<SMSResponse>, t: Throwable) {
                Log.d("SMS", "SMS Sending Error" )

            }

            override fun onResponse(call: Call<SMSResponse>, response: Response<SMSResponse>) {
                if (response.isSuccessful) {
                    Log.d("SMS", "SMS Success Sending!!")
                }
            }

        })

        return response
    }

}