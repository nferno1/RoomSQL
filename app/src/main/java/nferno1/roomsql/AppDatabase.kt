package nferno1.roomsql

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [User::class, Address::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

}