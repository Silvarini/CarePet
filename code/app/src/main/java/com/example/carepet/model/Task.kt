package com.example.carepet.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*



@Entity
data class Task (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "task_id")
        val taskId: Int,

        @ColumnInfo(name = "task_title")
        val taskTitle: String,

        @ColumnInfo(name = "task_initial_date_day")
        val taskDateDay: Int,

        @ColumnInfo(name = "task_initial_date_month")
        val taskDateMonth: Int,

        @ColumnInfo(name = "task_initial_date_year")
        val taskDateYear: Int,

        @ColumnInfo(name = "task_initialHour")
        val taskInitialHour: Int,

        @ColumnInfo(name = "task_initialMinutes")
        val taskInitialMinutes: Int,

        @ColumnInfo(name = "task_finalHour")
        val taskFinalHour: Int,

        @ColumnInfo(name = "task_finalMinutes")
        val taskFinalMinutes: Int,

        @ColumnInfo(name = "task_completion")
        val taskCompletion: String,

        @ColumnInfo(name = "task_user_id")
        val userId: Int

)