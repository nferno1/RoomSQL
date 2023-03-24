package nferno1.roomsql

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "play_list_song",
    primaryKeys = ["play_list_id", "song_id"]
)
data class PlayListSong(
    @ColumnInfo(name = "play_list_id")
    val playListId: Int,
    @ColumnInfo(name = "song_id")
    val songId: Int
)
