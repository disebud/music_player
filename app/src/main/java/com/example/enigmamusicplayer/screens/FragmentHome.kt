package com.example.enigmamusicplayer.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigmamusicplayer.AlbumRecycleAdapter
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment(), View.OnClickListener {

    private val albumViewModel by activityViewModels<AlbumViewModel>()
    private lateinit var albumRecycleAdapter: AlbumRecycleAdapter
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        song_recycle_view.layoutManager = LinearLayoutManager(activity)
        albumViewModel.allAlbum.observe(viewLifecycleOwner, Observer {
            albumRecycleAdapter = AlbumRecycleAdapter(it, activity)
            song_recycle_view.adapter = albumRecycleAdapter
        })

        fab.setOnClickListener(this)
        navController= Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when(v){
            fab -> {navController.navigate(R.id.action_fragmentHome_to_inputAlbumFragment)}
        }
    }
}