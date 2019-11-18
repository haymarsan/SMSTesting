package com.haymarsan.smstesting.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Response(
    @SerializedName("ResponseCode") val ResponseCode: String,
    @SerializedName("ResponseDescription") val ResponseDescription: String) : Serializable