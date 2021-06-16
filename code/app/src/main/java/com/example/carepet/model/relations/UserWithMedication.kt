package com.example.carepet.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.carepet.model.Doses
import com.example.carepet.model.Medication
import com.example.carepet.model.User

data class UserWithMedication (
        @Embedded val user: User,
        @Relation(
                parentColumn = "user_id",
                entityColumn = "medication_user_id"
        )
        val medications: List<Medication>,
        val doses: List<Doses>
)