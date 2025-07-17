package restfullapi.notes.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import restfullapi.notes.model.CreateNoteRequest
import restfullapi.notes.model.NoteResponse
import restfullapi.notes.model.WebResponse
import restfullapi.notes.service.NoteService

@RestController
class NoteController (
    @Autowired
    val noteService: NoteService
) {

    @PostMapping("/api/notes")
    fun create(@Valid @RequestBody request: CreateNoteRequest):WebResponse<NoteResponse>{
        val noteResponse = noteService.createNote(request)
        return WebResponse(
            data = noteResponse,
            error = null
        )
    }
}