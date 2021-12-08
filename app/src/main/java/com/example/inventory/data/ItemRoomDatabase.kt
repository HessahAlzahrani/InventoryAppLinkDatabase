package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Item::class], version = 1, exportSchema = false)

     //create database class ###

abstract class ItemRoomDatabase : RoomDatabase() {

    // fun create body function on another place ###
    abstract fun itemDao():ItemDao

    //ignore create another object on class
    companion object{
        @Volatile
        private var INSTANCE: ItemRoomDatabase?= null


        fun getDatabase(context: Context):ItemRoomDatabase{
            return INSTANCE ?:synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                        INSTANCE = instance
                    return instance


            }

        }

    }

}