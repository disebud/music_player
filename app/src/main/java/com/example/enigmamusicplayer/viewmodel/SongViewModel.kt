package com.example.enigmamusicplayer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongViewModel: ViewModel() {
    private val song:MutableList<MutableMap<String,String>>
            =
        mutableListOf(mutableMapOf(
            "name" to "Sheila on 7",
            "title" to "Musim Yang Baik",
            "image" to "https://img.beritasatu.com/cache/jakartaglobe/960x620-4/2015/03/s07.png"),
        mutableMapOf(
            "name" to "Dhyo Haw",
            "title" to "Always Positive",
            "image" to "https://m.media-amazon.com/images/I/61DLT6iFTcL._SS500_.jpg"),
        mutableMapOf(
            "name" to "Superman Is Dead",
            "title" to "Jadilah Legenda",
            "image" to "https://3.bp.blogspot.com/-6iuNc--j7IU/WlsTXv2M61I/AAAAAAAAAjE/drVwk0m8aHIJ1GYYYrPOc27sCHza4THKQCLcBGAs/s1600/17.jpg"),
        mutableMapOf(
            "name" to "FourTwnty",
            "title" to "Keluarlah dari Zona Nyaman",
            "image" to "https://www.nontoners.com/wp-content/uploads/2017/04/zonanyaman.jpg"))
    val songData:MutableLiveData<MutableList<MutableMap<String,String>>> = MutableLiveData(song)
    val details:MutableMap<String,String> = mutableMapOf()
    fun addSong(name:String,title:String,image:String){
        var inputData:MutableMap<String,String> =
            mutableMapOf("name" to name,"title" to title,"image" to image)
        song.add(inputData)
        songData.value = song
    }

    fun detailSong(position:Int){
        val detail = song.get(position)
        details.put("name", detail["name"].toString())
        details.put("title",detail["title"].toString())
        details.put("image",detail["image"].toString())
    }
}