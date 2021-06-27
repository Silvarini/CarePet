package com.example.carepet.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.carepet.model.Doses
import com.example.carepet.model.Medication


data class MedicationWithDoses (
        @Embedded val medication: Medication,
        @Relation(
                parentColumn = "medication_id",
                entityColumn = "doses_medication_Id"
        )
        val doses: List<Doses>
)


