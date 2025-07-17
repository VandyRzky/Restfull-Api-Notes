package restfullapi.notes.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import restfullapi.notes.model.CreateNoteRequest
import restfullapi.notes.model.NoteResponse
import restfullapi.notes.model.UpdateNoteRequest
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

    @GetMapping("/api/notes")
    fun getAll():WebResponse<List<NoteResponse>>{
        val listOfNoteResponse = noteService.getAllNotes()
        return WebResponse(
            data = listOfNoteResponse,
            error = null
        )
    }

    @GetMapping("/api/notes/{idNote}")
    fun getNote(@PathVariable("idNote") id:String):WebResponse<NoteResponse>{
        val noteResponse = noteService.getNote(id)
        return WebResponse(
            data = noteResponse,
            error = null
        )
    }

    @PatchMapping("/api/notes/{idNote}")
    fun updateNote(@PathVariable("idNote") id:String,
                   @RequestBody request: UpdateNoteRequest): WebResponse<NoteResponse>{
        val noteResponse = noteService.updateNote(id, request )
        return WebResponse(
            data = noteResponse,
            error = null
        )
    }

    @DeleteMapping("/api/notes/{idNote}")
    fun deleteNote(@PathVariable("idNote")id: String): WebResponse<String>{
        noteService.deleteNote(id)
        return WebResponse(
            data = "Berhasil menghapus",
            error = null
        )
    }
}