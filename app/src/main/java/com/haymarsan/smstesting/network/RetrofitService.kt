package com.haymarsan.smstesting.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST



class RetrofitService {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun <S> createService(serviceClass: Class<S>):S{
        return retrofit.create(serviceClass)
    }

}

//http://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com/oauthserver/api/oauth/requesttoken
//http://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com/kbzapi/api/telco/sendsms
