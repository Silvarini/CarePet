package com.example.carepet.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user",
    indices = [Index("user_username")]
)

data class User(
    @PrimaryKey
    @ColumnInfo
    (name = "user_username")
    val userUsername: String,

    @ColumnInfo(name = "user_name")
    val name: String,

    @ColumnInfo(name = "user_pettingScore")
    val pettingScore: Int,

    @ColumnInfo(name = "user_taskScore")
    val taskScore: Int
)
