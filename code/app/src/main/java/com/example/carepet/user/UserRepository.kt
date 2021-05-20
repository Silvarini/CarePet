package com.example.carepet.user

import androidx.annotation.WorkerThread
import com.example.carepet.model.User
import com.example.carepet.storage.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDAO: UserDao) {

    @WorkerThread
    suspend fun insertOrUpdateUser(user: User){
        userDAO.insertOrUpdateUser(user)
    }


    val getAllUserData: Flow<List<User>> = userDAO.getAllUserData()


}