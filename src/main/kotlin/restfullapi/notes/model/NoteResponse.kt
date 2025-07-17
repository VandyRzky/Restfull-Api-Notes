package restfullapi.notes.model

import java.util.Date

data class NoteResponse(
    var id: String,
    var title: String,
    var content: String,
    var created_at: Date,
    var updated_at: Date?
)