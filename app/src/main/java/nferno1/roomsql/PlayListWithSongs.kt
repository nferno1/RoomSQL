package nferno1.roomsql

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class PlayListWithSongs(
    @Embedded
    val playList: PlayList,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            PlayListSong::class,
            parentColumn = "play_list_id",
            entityColumn = "song_id"
        )
    )
    val song: List<Song>
)
