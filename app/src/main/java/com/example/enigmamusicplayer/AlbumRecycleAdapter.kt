package com.example.enigmamusicplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmamusicplayer.room.music.Album
import com.squareup.picasso.Picasso

class AlbumRecycleAdapter(
    private val albumList: List<Album>,
    private val getActivity: FragmentActivity?
): RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item_layout, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.songTitle.text = albumList[position].albumTitle
        holder.artistSong.text = albumList[position].artistName
        Picasso.with(getActivity).load(albumList[position].albumImage).into(holder.imageSong)
        val bundle = bundleOf(Pair("albumId", albumList[position].albumId))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmentHome_to_detailFragment, bundle)
        }
    }

}

class AlbumViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val songTitle: TextView = v.findViewById<TextView>(R.id.song_title)
    val artistSong: TextView = v.findViewById<TextView>(R.id.artist_song)
    val imageSong: ImageView = v.findViewById<ImageView>(R.id.image_song)
}

