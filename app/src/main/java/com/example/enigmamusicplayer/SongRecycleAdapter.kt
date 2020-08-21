package com.example.enigmamusicplayer

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmamusicplayer.room.music.Song
//import com.example.enigmamusicplayer.utils.ConvertBitmap
import com.example.enigmamusicplayer.viewmodel.SongViewModel
import java.lang.Exception
import java.net.URL

class SongRecycleAdapter(private val listSong: List<Song>) :

    RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = listSong[position].songName
        holder.songDuration.text = listSong[position].songDuration
        holder.playMusic.setOnClickListener {
            holder.playMusic.setImageResource(R.drawable.ic_baseline_pause_24)
        }
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

}

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val songTitle: TextView = view.findViewById<TextView>(R.id.songTitleDetailNew)
    val songDuration: TextView = view.findViewById<TextView>(R.id.songDurationNew)
    val playMusic: ImageView = view.findViewById<ImageView>(R.id.playMusicNew)
}


//class SongRecycleAdapter(private val songViewModel: SongViewModel): RecyclerView.Adapter<SongViewHolder>() {
//    lateinit var context:Context
//    lateinit var navController: NavController
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_item_layout,parent,false)
//        context = parent.context
//        return SongViewHolder(view,songViewModel)
//    }
//
//    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
//        holder.artist.text = songViewModel.songData.value!![position]["name"]
//        holder.songTitle.text = songViewModel.songData.value!![position]["title"]
//        holder.index = position
//        var imageName = songViewModel.songData.value!![position]["image"]
//        ConvertBitmap(holder.imageAlbum).execute(imageName)
//        holder.itemView.setOnClickListener(holder)
//    }
//
//    override fun getItemCount(): Int {
//        return songViewModel.songData.value!!.size
//    }
//
//}
//
//class SongViewHolder(
//    v: View,val songViewModel: SongViewModel
//):RecyclerView.ViewHolder(v),View.OnClickListener {
//    var index:Int = 0
//    val songTitle: TextView = v.findViewById<TextView>(R.id.songTitle_text)
//    val artist: TextView = v.findViewById<TextView>(R.id.artis_text)
//    val imageAlbum: ImageView = v.findViewById(R.id.imageSong)
//
//    override fun onClick(v: View?) {
//        when(v){
//            itemView -> {
//                songViewModel.detailSong(index)
//                Toast.makeText(v?.context,"${songTitle.text} is Clicked", Toast.LENGTH_SHORT).show()
//                itemView.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
//            }
//        }
//    }
//}