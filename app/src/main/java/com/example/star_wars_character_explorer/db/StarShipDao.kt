package com.example.star_wars_character_explorer.db

import androidx.paging.PagingSource
import androidx.room.*
import com.example.star_wars_character_explorer.service.model.StarShip

@Dao
interface StarShipDao {

//    //for getting starship based on page wise
//    @Query("SELECT * FROM StarShip")
//    fun getAllStarShip() : PagingSource<Int,StarShip>
//
//    //insert list of StarShip into local db
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertStarShip(starShips : List<StarShip>)
//
//    //delete all StarShip record from local db
//    @Query("DELETE FROM StarShip")
//    suspend fun deleteStarShips()


}