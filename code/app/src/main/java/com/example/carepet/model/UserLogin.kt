package com.example.carepet.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserLogin (
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo
        (name = "userLogin_username")
        val username: String,

        @ColumnInfo(name = "userLogin_password")
        val password: String,

        @ColumnInfo(name = "userLogin_user_id")
        val userId : Int
/*
        @ColumnInfo(name = "userLogin_date")
        val date: Date?,

        @ColumnInfo(name = "userLogin_time")
        val taskScore: Int
  */    )