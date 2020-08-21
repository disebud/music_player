package com.example.enigmamusicplayer.room.music

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface MusicDao {

    @Transaction
    @Query("SELECT * FROM Album")
    fun getAlbumWithSong(): LiveData<List<AlbumWithSong>>

    @Query("SELECT * FROM Album")
    fun getAllAlbum(): LiveData<List<Album>>

    @Query(value = "SELECT * FROM Album WHERE albumId = :id")
    fun getAlbumWithId(id:Int): LiveData<Album>

    @Insert
    fun createNewAlbum(album: Album)

    @Query(value = "SELECT * FROM Song WHERE songAlbumId = :id")
    fun getSongWithAlbumId(id:Int): LiveData<List<Song>>

    @Insert
    fun createNewSong(song: Song)
}