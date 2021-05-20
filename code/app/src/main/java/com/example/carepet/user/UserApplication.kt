package com.example.carepet.user

import android.app.Application
import com.example.carepet.storage.UserDatabase

class UserApplication: Application() {

    private val database by lazy {
        UserDatabase.getDatabase(this@UserApplication)
    }

    val repository by lazy {
        UserRepository(database.userDao())
    }


}