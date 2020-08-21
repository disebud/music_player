package com.example.enigmamusicplayer.room.music

import androidx.lifecycle.LiveData

class MusicRepository (private val musicDao: MusicDao) {

    val allAlbum: LiveData<List<Album>> = musicDao.getAllAlbum()

    fun getAlbumWithSong() = musicDao.getAlbumWithSong()

    fun getAlbumWithId(id: Int) = musicDao.getAlbumWithId(id)

    fun createNewAlbum(album: Album) = musicDao.createNewAlbum(album)

    fun getSongWithAlbumId(id: Int) = musicDao.getSongWithAlbumId(id)

    fun createNewSong(song: Song) = musicDao.createNewSong(song)
}