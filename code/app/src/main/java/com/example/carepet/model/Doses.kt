package com.example.carepet.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Doses(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "dose_id")
        val doseId: Int,

        @ColumnInfo(name = "doses_quantity")
        val quantity: Int,

        @ColumnInfo(name = "doses_scheduleHour")
        val scheduleDoseHour: Int,

        @ColumnInfo(name = "doses_scheduleMinutes")
        val scheduleDoseMinutes: Int,

        @ColumnInfo(name = "doses_medication_Id")
        val medicationId: Int?

)

