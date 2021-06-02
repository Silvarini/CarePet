package com.example.carepet.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carepet.model.Medication
import com.example.carepet.model.Task
import com.example.carepet.model.User
import com.example.carepet.model.UserLogin
import com.example.carepet.model.relations.UserWithMedication
import com.example.carepet.model.relations.UserWithTasks
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateMedication(medication: Medication)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTask(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUserLogin(userLogin: UserLogin)


    @Transaction
    @Query("SELECT * FROM user ORDER BY user_id ASC")
    fun getAllUserData(): Flow<List<User>>


    @Transaction
    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getMedicationsOfUser(userId: Int): Flow<List<UserWithMedication>>


    @Transaction
    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getTasksOfUser(userId: Int): Flow<List<UserWithTasks>>



    // User @Transaction to get UserLogin attributes to correct the multithreading with this function.






    // @Delete
   // suspend fun deleteAll(user: User)
}
