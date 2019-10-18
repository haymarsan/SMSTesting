package com.haymarsan.smstesting.data

data class SMSVO (
    val telCode:String,
    val subscriberNum:String,
    val message:String,
    val trxnRefNum:String,
    val clientCode:String
)