package com.example.carepet.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Doses(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "medicationId")
    val medicationId : Int,

    @ColumnInfo(name = "doses_scheduleHour")
    val scheduleDoseHour: Int,

    @ColumnInfo(name = "doses_scheduleMinutes")
    val scheduleDoseMinutes: Int

)

