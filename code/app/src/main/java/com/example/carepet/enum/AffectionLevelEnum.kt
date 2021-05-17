package com.example.carepet.enum

enum class AffectionLevelEnum(
        PETTING: String,
        MEDICATION_TAKING: String,
        TASK_NOTIFICATION: String,
        TASK_COMPLETED: String,
        TASK_SNOOZED: String,
        TASK_SKIPPED: String
) {
        ONE(
                MEDICATION_TAKING = "Vamos tomar a medicação!",
                TASK_NOTIFICATION = "Tens uma tarefa marcada para agora!",
                        PETTING = "Gosto das tuas festinhas!",
                TASK_COMPLETED = "Bom trabalho!",
                TASK_SNOOZED = "Ok, não volto a chamar-te daqui a 10 min!",
                TASK_SKIPPED = "Ok, não volto a chamar-te para esta"

        ),
        TWO(
                "As tuas festinhas são sempre as melhores!",
                "Gosto que estejas empenhado! Vamos tomar a medicação!",
                "Estás a fazer tanto! Temos mais uma tarefa para esta hora!",
                "Estás a ir bem!",
                "Ok, não volto a chamar-te daqui a 10 min!",
                "Ok, não volto a chamar-te para esta"
        ),
        THREE(
                "Adoro-te!",
                "Adoro o tempo que tenho passado consigo! Vamos tomar a medicação!",
                "Impressionante que já fizeste imenso! Temos mais uma tarefa para esta hora!",
                "Estou orgulhoso de ti!",
                "Ok, não volto a chamar-te daqui a 10 min!",
                "Ok, não volto a chamar-te para esta"
        )
}
