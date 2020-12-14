package com.zionhuang.music.db.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zionhuang.music.db.entities.ArtistEntity

@Dao
interface ArtistDao {
    @Query("SELECT * FROM artist")
    fun getAllArtistsAsPagingSource(): PagingSource<Int, ArtistEntity>

    @Query("SELECT id FROM artist WHERE name = :name")
    fun getArtistIdByName(name: String): Int?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(artist: ArtistEntity): Long
}