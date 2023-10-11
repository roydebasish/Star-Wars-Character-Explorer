package com.example.star_wars_character_explorer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.star_wars_character_explorer.service.model.StarShip
import com.example.star_wars_character_explorer.service.model.StarShipRemoteKeys

//@Database(entities = [StarShip::class,StarShipRemoteKeys::class], version = 1)
abstract class StarWarsDatabse : RoomDatabase(){

//    abstract fun starShipDao() : StarShipDao
//    abstract fun starShipRemoteKeys() : StarShipRemoteKeys

}