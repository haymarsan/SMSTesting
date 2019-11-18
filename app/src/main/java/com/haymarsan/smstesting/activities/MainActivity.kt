package com.haymarsan.smstesting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.haymarsan.smstesting.R
import com.haymarsan.smstesting.data.SMSVO
import com.haymarsan.smstesting.utils.PreferenceUtils
import com.haymarsan.smstesting.viewmodel.SMSViewModelImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel:SMSViewModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProviders.of(this).get(SMSViewModelImpl::class.java)

        myViewModel.getToken(userName = "KBZONBO", password = "!ad@Pi17", grantType = "password").observe(this, Observer {

            PreferenceUtils.saveData(this, "AuthToken", it.access_token)
            Log.d("AuthToken", it.access_token)

        })




        btnGetCode.setOnClickListener {
            val authKey = PreferenceUtils.loadData(this,"AuthToken")
            val sms = SMSVO("MGATE", "09794287844", "110191", "20191118112612356", "ONB" )
            myViewModel.getSMS(authKey, smsvo = sms ).observe(this, Observer {
                if (it.TrxnRefNum == sms.trxnRefNum){
                    Toast.makeText(this, "OTP${sms.message}", Toast.LENGTH_SHORT).show()
                }
            })

        }
    }
}
