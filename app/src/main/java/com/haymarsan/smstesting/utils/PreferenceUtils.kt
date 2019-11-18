package com.haymarsan.smstesting.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtils {

companion object{
    fun saveData(context: Context, key: String, value: Any){

        val preference = context.applicationContext.getSharedPreferences( "TokenVO", Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(key, "${value}")
        editor.apply()

    }
}


}