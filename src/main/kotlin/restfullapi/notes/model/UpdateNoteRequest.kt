package restfullapi.notes.model

import jakarta.validation.constraints.Size

data class UpdateNoteRequest (

    @Size(max = 100)
    var title: String,


    var content: String,
)