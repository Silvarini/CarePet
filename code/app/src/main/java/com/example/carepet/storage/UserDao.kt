package com.example.carepet.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carepet.model.User

@Dao
interface   UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUserData(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateScores(user: User)

    @Query("DELETE * FROM user")
    suspend fun deleteAll()
}
