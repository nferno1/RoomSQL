package nferno1.roomsql

import android.app.Application
import androidx.room.Room

class App: Application() {

    lateinit var db: AppDatabase

    private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        db = Room
            .inMemoryDatabaseBuilder(
            this,
            AppDatabase::class.java

        )
            .fallbackToDestructiveMigration() // для уничтожения и перезагрузки бд заново
            .build()
    }
    companion object {
        lateinit var INSTANCE: App
        private set
    }
}