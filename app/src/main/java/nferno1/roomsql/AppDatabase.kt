package nferno1.roomsql

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        User::class,
        Address::class,
        PlayList::class,
        Song::class,
        PlayListSong::class
               ],
    version = 2,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

}