package com.haymarsan.smstesting.viewmodel

import androidx.lifecycle.LiveData
import com.haymarsan.smstesting.data.SMSResponse
import com.haymarsan.smstesting.data.SMSVO
import com.haymarsan.smstesting.data.TokenVO

interface SMSViewModel {

    fun getToken(userName:String, password: String, grantType: String): LiveData<TokenVO>

    fun getSMS(authKey: String, smsvo: SMSVO): LiveData<SMSResponse>

}