package com.haymarsan.smstesting.repository

import com.haymarsan.smstesting.data.Token
import com.haymarsan.smstesting.network.RetrofitService
import com.haymarsan.smstesting.network.SmsApi

class repository {

    lateinit var api: SmsApi


    init {
            api = RetrofitService().createService(SmsApi::class.java)
    }



    fun getOAuthToken(userName:String, password: String, expiredIn: Int): Token{

       



        return

    }

}