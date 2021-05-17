package com.example.carepet.user

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.carepet.model.User
import com.example.carepet.storage.UserDao
import com.example.carepet.storage.UserDatabase

class UserRepository(application: Application) {

    val db: UserDatabase = UserDatabase.getDatabase(application)

    private val userDao: UserDao = db.userDao()
    private val allUserData: LiveData<List<User>>? = userDao.getAllUserData()

    fun getAllUserData(): LiveData<List<User>>? {
        return allUserData
    }


}