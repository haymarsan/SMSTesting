package com.haymarsan.smstesting.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TokenVO (
    @SerializedName("version") val access_token: String,
    @SerializedName("token_type") val token_type: String,
    @SerializedName("expires_in") val expires_in: Int
): Serializable