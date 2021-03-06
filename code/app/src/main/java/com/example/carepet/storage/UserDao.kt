package com.example.carepet.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carepet.model.*
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
    suspend fun insertOrUpdateDoses(doses: Doses)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTask(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUserLogin(userLogin: UserLogin)


    @Transaction
    @Query("SELECT * FROM user ORDER BY user_id ASC")
    fun getAllUserData(): Flow<List<User>>


    @Transaction
    @Query("SELECT * FROM Medication WHERE medication_user_id = :userId")
    fun getMedicationsOfUser(userId: Int): Flow<List<Medication>>


    @Transaction
    @Query("SELECT MAX(medication_id) FROM Medication")
    fun getMedicationId(): Flow<Int>


    @Transaction
    @Query("SELECT * FROM Task WHERE task_user_id = :userId")
    fun getTasksOfUser(userId: Int): Flow<List<Task>>



    // User @Transaction to get UserLogin attributes to correct the multithreading with this function.






    // @Delete
   // suspend fun deleteAll(user: User)
}
