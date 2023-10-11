package com.example.star_wars_character_explorer.db

import androidx.paging.PagingSource
import androidx.room.*
import com.example.star_wars_character_explorer.service.model.StarShip
import com.example.star_wars_character_explorer.service.model.StarShipRemoteKeys

@Dao
interface StarShipRemoteKeysDao {
//
//    //for getting starship based on page wise
//    @Query("SELECT * FROM StarShipRemoteKeys WHERE name =:name")
//    suspend fun getAllStarShipRemoteKeys(name : String) : StarShipRemoteKeys
//
//    //insert list of starship into local db
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertStarShipRemoteKeys(starShips : List<StarShipRemoteKeys>)
//
//    //delete all starship record from local db
//    @Query("DELETE FROM StarShipRemoteKeys")
//    suspend fun deleteStarShipRemoteKeys()


}