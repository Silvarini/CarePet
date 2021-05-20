package com.example.carepet.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user",
    indices = [Index("user_id")]
)

data class User(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo
    (name = "user_id")
    val userId: Int,

    @ColumnInfo(name = "user_name")
    val name: String,

    @ColumnInfo(name = "user_pettingScore")
    val pettingScore: Int,

    @ColumnInfo(name = "user_taskScore")
    val taskScore: Int
)
