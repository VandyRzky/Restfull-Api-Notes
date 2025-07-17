package restfullapi.notes.repository

import org.springframework.data.jpa.repository.JpaRepository
import restfullapi.notes.entity.Note

interface NoteRepository: JpaRepository<Note, String> {
}