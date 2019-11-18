package com.haymarsan.smstesting.viewmodel

import androidx.lifecycle.LiveData
import com.haymarsan.smstesting.data.TokenVO

interface SMSViewModel {

    fun getToken(userName:String, password: String, grantType: String): LiveData<TokenVO>

}