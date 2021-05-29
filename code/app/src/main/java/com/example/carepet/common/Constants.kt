package com.example.carepet.common

object Constants {

    const val USER_SOURCE_LOCAL : String = "Local"
    const val USER_SOURCE_ONLINE : String = "Online"
    const val MEDICATION_DURATION: String = "Medication Duration"

    fun durationTypes():ArrayList<String>{
        val list = ArrayList<String>()
        list.add("Forever")
        list.add("Once")
        list.add("Weekly")
        list.add("Monthly")
        return list
    }










}