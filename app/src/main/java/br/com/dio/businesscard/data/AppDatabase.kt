package br.com.dio.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// Clasee que o Room irá enxergar, ela será responsavel por gerenciar o banco de dados

// @Database -> deve conter as entidades que temos no projeto
@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun businessDao() : BusinessCardDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}