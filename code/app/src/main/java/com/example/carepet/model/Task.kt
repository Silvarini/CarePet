package com.example.carepet.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Task (
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "task_id")
        val taskId: Int,

        @ColumnInfo(name = "task_title")
        val taskName: String,

        @ColumnInfo(name = "task_initial_date")
        val taskInitialDate: Date?,

        @ColumnInfo(name = "task_duration")
        val taskDuration: Int,

        @Embedded
        val taskWeekdays: Weekdays,

        @ColumnInfo(name = "task_repetitions")
        val taskDailyRepetitions: String,

        @ColumnInfo(name = "task_quantity")
        val taskPeriodQuantity: Int,

        @ColumnInfo(name = "task_user_id")
        val userId: Int

)