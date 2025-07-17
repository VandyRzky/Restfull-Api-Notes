package restfullapi.notes.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "notes")
data class Note(
    @Id
    val id: String,

    var title: String,

    var content: String,

    @Column(name = "created_at")
    var createdAt: String,

    @Column(name = "updated_at")
    var updatedAt: String?
)
