package nferno1.roomsql

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithAddress(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "user_id"
    )
    val address: Address?,
@Relation(
    entity = PlayList::class,
    parentColumn = "id",
    entityColumn = "user_id"
)
val playList: List<PlayListWithSongs>?
)





