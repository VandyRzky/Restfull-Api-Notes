package restfullapi.notes.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateNoteRequest(

    @field:NotBlank
    @Size(max = 100)
    var title: String,

    @field:NotBlank
    var content: String,

)