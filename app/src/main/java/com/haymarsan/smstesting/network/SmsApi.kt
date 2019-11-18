package com.haymarsan.smstesting.network

import com.haymarsan.smstesting.data.SMSVO
import com.haymarsan.smstesting.data.TokenVO
import retrofit2.Call
import retrofit2.http.*

interface SmsApi {

    @FormUrlEncoded
    @POST("oauthserver/api/oauth/requesttoken")
    fun getToken(@Field("username") username: String,
                 @Field("password") password: String,
                 @Field("grant_type") grantType: String): Call<TokenVO>


    @FormUrlEncoded
    @POST("kbzapi/api/telco/sendsms")
    fun getSMS(@Body telCode: String,
               subscriberNum: String,
               message: String,
               trxnRefNum: String,
               clientCode: String): Call<SMSVO>


}