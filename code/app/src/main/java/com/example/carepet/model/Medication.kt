package com.example.carepet.model

import androidx.room.*
import java.util.*


@Entity
data class Medication(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo
    (name = "medication_id")
    val medicationId: Int,

    @ColumnInfo(name = "medication_name")
    val medicationName: String,

    @ColumnInfo(name = "medication_photo")
    val medicationPhoto: String,

    @ColumnInfo(name = "medication_initial_date")
    val medicationInitialDate: Date?,

    @ColumnInfo(name = "medication_duration")
    val medicationDuration: Int,

    @Embedded
    val medicationWeekdays: Weekdays,

    @ColumnInfo(name = "medication_repetitions")
    val medicationDailyRepetitions: Int,

    @ColumnInfo(name = "medication_quantity")
    val medicationPeriodQuantity: Int,

    @ColumnInfo(name = "medication_user_id")
    val userId: Int

)