package restfullapi.notes.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import restfullapi.notes.entity.Note
import restfullapi.notes.model.CreateNoteRequest
import restfullapi.notes.model.NoteResponse
import restfullapi.notes.model.UpdateNoteRequest
import restfullapi.notes.repository.NoteRepository
import java.util.Date
import java.util.UUID

@Service
class NoteService(
    @Autowired
    val noteRepository: NoteRepository
) {
    fun createNote(request: CreateNoteRequest): NoteResponse {
        if (request.title.isNullOrBlank() || request.content.isNullOrBlank()){
            throw IllegalArgumentException("Data tidak boleh kosong")
        }

        val note = Note(
            id = UUID.randomUUID().toString(),
            title = request.title,
            content = request.content,
            createdAt = Date(),
            updatedAt = null
        )

        noteRepository.save(note)

        return toNoteResponse(note)
    }

    fun getAllNotes():List<NoteResponse>{
        return noteRepository.findAll().map { value ->
            toNoteResponse(value)
        }
    }

    fun getNote(id: String):NoteResponse{
        val note = findNote(id)

        return toNoteResponse(note)
    }

    fun updateNote(id:String, request:UpdateNoteRequest):NoteResponse{
        val note = findNote(id)
        var isUpdate = false

        if (request.title.isNullOrBlank() && request.content.isNullOrBlank()){
            throw IllegalArgumentException("Gagal melakukan update")
        }

        if (!request.title.isNullOrBlank() && request.title != note.title){
            note.title = request.title
            isUpdate = true
        }
        if (!request.content.isNullOrBlank() && request.content != note.content){
            note.content = request.content
            isUpdate = true
        }

        if (isUpdate) {
            note.updatedAt = Date()
            noteRepository.save(note)
        }
        return toNoteResponse(note)
    }

    fun deleteNote(id: String){
        val note = findNote(id)
        noteRepository.delete(note)
    }

    private fun findNote(id: String):Note{
        val note = noteRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("Data tidak ada")
        return note
    }

    private fun toNoteResponse(note: Note): NoteResponse{
        return NoteResponse(
            id = note.id,
            title = note.title,
            content = note.content,
            created_at = note.createdAt,
            updated_at = note.updatedAt
        )
    }
}