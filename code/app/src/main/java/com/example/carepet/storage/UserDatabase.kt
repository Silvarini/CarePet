package com.example.carepet.storage


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.carepet.common.Converters
import com.example.carepet.model.Medication
import com.example.carepet.model.Task
import com.example.carepet.model.User
import com.example.carepet.model.UserLogin

/**
 * The underlying database where information about the donuts is stored.
 */
@Database(entities = [
    User::class,
    Medication::class,
    Task::class,
    UserLogin::class
    ],
        version = 2
)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}