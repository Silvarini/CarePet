package com.example.carepet.model

import android.graphics.Bitmap
import androidx.room.*
import com.example.carepet.enum.DurationTypes
import java.util.*
import kotlin.collections.ArrayList


@Entity
data class Medication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medication_id")
    val medicationId: Int,

    @ColumnInfo(name = "medication_photo")
    val medicationPhoto: String,

    @ColumnInfo(name = "medication_repetitions")
    val medicationDailyRepetitions: Int, //how many doses of that medication exist

    @ColumnInfo(name = "medication_duration")
    val medicationDuration: String,

    @ColumnInfo(name = "medication_quantity")
    val medicationDurationQuantity: Int,

    @Embedded
    val medicationWeekdays: Weekdays,

    @ColumnInfo(name = "medication_user_id")
    val userId: Int


)
