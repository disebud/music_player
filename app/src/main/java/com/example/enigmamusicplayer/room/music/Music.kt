package com.example.enigmamusicplayer.room.music

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Album(
    @PrimaryKey(autoGenerate = true) val albumId: Int = 0,
    val albumTitle: String,
    val artistName: String,
    val albumImage: String
)

@Entity
data class Song(
    @PrimaryKey(autoGenerate = true) val songId: Int = 0,
    val songAlbumId: Int,
    val songName: String,
    val songDuration: String
)


data class AlbumWithSong(
    @Embedded val album: Album,
    @Relation(
        parentColumn = "albumId",
        entityColumn = "songAlbumId"
    )
    val song: Song
)