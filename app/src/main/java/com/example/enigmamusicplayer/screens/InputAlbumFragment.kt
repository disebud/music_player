package com.example.enigmamusicplayer.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.room.music.Album
import com.example.enigmamusicplayer.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_input_album.*

class InputAlbumFragment : Fragment(), View.OnClickListener {

    private val songViewModel by activityViewModels<AlbumViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        button_save.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            button_save->{
                val albumTitle = input_song_title.text.toString()
                val artistName = input_artist_name.text.toString()
                val albumImage = input_song_image.text.toString()
                songViewModel.createNewAlbum(Album(albumTitle = albumTitle, artistName = artistName, albumImage = albumImage ))
                Toast.makeText(v?.context,"SUCCESS: Add Album", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_inputAlbumFragment_pop)
            }

        }
    }

}