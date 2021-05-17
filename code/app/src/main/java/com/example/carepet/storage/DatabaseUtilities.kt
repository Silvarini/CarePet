package com.example.carepet.storage

import com.example.carepet.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun rePopulateDatabase(database: UserDatabase) {

    database?.let { db ->
        withContext(Dispatchers.IO) {
            val userDao: UserDao = db.userDao()

            userDao.deleteAll()

            val user = User(userUsername = "carlos.malato@email.com", name = "Carlos", pettingScore = 0, taskScore = 0)

            userDao.insertOrUpdateScores(user)
        }
    }
}