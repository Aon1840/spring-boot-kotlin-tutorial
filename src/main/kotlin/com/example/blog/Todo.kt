import javax.persistence.Entity

@Entity
data class Todo(
        var id: Long? = null,
        var name: String? = null
)