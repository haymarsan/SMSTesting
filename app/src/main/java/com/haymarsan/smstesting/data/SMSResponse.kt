package com.haymarsan.smstesting.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SMSResponse(
    @SerializedName("TrxnRefNum") val TrxnRefNum: String,
    @SerializedName("Response") val Response: ArrayList<Response>): Serializable