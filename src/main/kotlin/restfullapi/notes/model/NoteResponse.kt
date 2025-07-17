package restfullapi.notes.model

data class NoteResponse(
    var id: String,
    var title: String,
    var content: String,
    var created_at: String,
    var updated_at: String?
)