package com.haymarsan.smstesting.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.haymarsan.smstesting.data.SMSResponse
import com.haymarsan.smstesting.data.SMSVO
import com.haymarsan.smstesting.data.TokenVO
import com.haymarsan.smstesting.repository.Repository

class SMSViewModelImpl(application: Application): AndroidViewModel(application), SMSViewModel {

    private val repository =  Repository()
    override fun getToken(
        userName: String,
        password: String,
        grantType: String
    ): LiveData<TokenVO> {
        return repository.getOAuthToken(userName, password, grantType)
    }


    override fun getSMS(authKey: String, smsvo: SMSVO): LiveData<SMSResponse> {
        return repository.getSMS(authKey, smsvo)
    }






}