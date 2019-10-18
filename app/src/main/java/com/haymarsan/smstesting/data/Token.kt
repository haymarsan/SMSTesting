package com.haymarsan.smstesting.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Token (
    @SerializedName("version") val access_token: String,
    @SerializedName("encoding") val token_type: String,
    @SerializedName("feed") val expires_in: Int
): Serializable