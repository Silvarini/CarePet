package com.example.carepet.user

import androidx.annotation.WorkerThread
import com.example.carepet.model.Doses
import com.example.carepet.model.Medication
import com.example.carepet.model.User
import com.example.carepet.model.relations.UserWithMedication
import com.example.carepet.storage.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDAO: UserDao) {

    @WorkerThread
    suspend fun insertOrUpdateUser(user: User){
        userDAO.insertOrUpdateUser(user)
    }

    @WorkerThread
    suspend fun insertOrUpdateMedication(medication: Medication){
        userDAO.insertOrUpdateMedication(medication)
    }

    @WorkerThread
    suspend fun insertOrUpdateDoses(doses: Doses){
        userDAO.insertOrUpdateDoses(doses)
    }


    val getAllUserData: Flow<List<User>> = userDAO.getAllUserData()

    val getAllMedication: Flow<List<Medication>> = userDAO.getMedicationsOfUser(1) // perceber se esta bem feita as querys e testar como no video a schema da base de dados.

}