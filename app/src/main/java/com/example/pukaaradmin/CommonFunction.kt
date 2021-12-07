package com.example.pukaaradmin

import android.content.Context
import android.content.SharedPreferences
import java.security.AccessControlContext

class CommonFunction {
    companion object {
        fun saveToken(context: Context, token: String) {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("token", token)
            editor.apply()
            editor.commit()
        }

        fun getToken(context: Context): String {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val token = sharedPreferences.getString("token", "")
            return "Bearer "+token.toString();
        }

        fun saveName(context: Context, name: String) {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("name", name)
            editor.apply()
            editor.commit()
        }

        fun getName(context: Context): String {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PukaarAdmin", Context.MODE_PRIVATE)
            val token = sharedPreferences.getString("name", "")
            return token.toString();
        }
    }
}