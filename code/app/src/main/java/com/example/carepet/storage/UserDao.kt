package com.example.carepet.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carepet.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user ORDER BY user_Id ASC")
    fun getAllUserData(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: User)




    // @Delete
   // suspend fun deleteAll(user: User)
}
