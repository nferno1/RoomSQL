package nferno1.roomsql

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlist")
data class PlayList(
    @PrimaryKey
    @ColumnInfo(name = "id" )
    val id: Int,
    @ColumnInfo(name = "user_id" )
    val userId: Int,
    @ColumnInfo(name = "name" )
    val name: String
)
