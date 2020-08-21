package com.example.enigmamusicplayer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.enigmamusicplayer.room.AppRoomDatabase
import com.example.enigmamusicplayer.room.music.Album
import com.example.enigmamusicplayer.room.music.MusicRepository
import com.example.enigmamusicplayer.room.music.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MusicRepository
    val allAlbum: LiveData<List<Album>>

    init {
        val musicDao = AppRoomDatabase.getDatabaseInstance(application).musicDao()
        repository = MusicRepository(musicDao)
        allAlbum = repository.allAlbum
    }

    //menggunakan coroutine
    //karena baik ke db maupun network itu membutuhkan waktu yang lebih ekstra
    fun createNewAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewAlbum(album)
        }
    }

    fun createNewSong(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewSong(song)
        }
    }

    fun getAlbumWithId(id: Int) = repository.getAlbumWithId(id)
    fun getSongWithAlbumId(id: Int) = repository.getSongWithAlbumId(id)
}