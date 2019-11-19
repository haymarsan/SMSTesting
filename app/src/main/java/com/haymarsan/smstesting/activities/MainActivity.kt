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
import java.text.SimpleDateFormat
import java.util.*

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


        val otp = (0..999999).shuffled().first()

        btnGetCode.setOnClickListener {
            //val authKey = PreferenceUtils.loadData(this,"AuthToken")
            val authKey = "bearer ${PreferenceUtils.loadData(this,"AuthToken")}"
            val sms = SMSVO("MGATE", editText.text.toString(), "Your otp is $otp", SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Date()), "ONB" )
            myViewModel.getSMS(authKey, smsvo = sms ).observe(this, Observer {

                    Toast.makeText(this, "OTP sent successfully", Toast.LENGTH_SHORT).show()

            })
        }


        btnVerify.setOnClickListener {

            if (otp.equals(editText2.text.toString())){

                Toast.makeText(this, "Verification Success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Verification Failed", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
