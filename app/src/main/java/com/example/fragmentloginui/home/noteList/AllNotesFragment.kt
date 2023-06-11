package com.example.fragmentloginui.home.noteList

import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentloginui.R

import com.example.fragmentloginui.databinding.AllNotesFragmentBinding
import com.example.fragmentloginui.databinding.RegisterFragmentBinding
import com.example.fragmentloginui.home.noteList.model.Post
import com.example.fragmentloginui.home.noteList.utils.PostApiState

class AllNotesFragment : Fragment(R.layout.all_notes_fragment) {
    private lateinit var binding: AllNotesFragmentBinding
    private val viewModel: PostViewModel by viewModels()
    private val adapterNoteListAdapter: NoteListAdapter = NoteListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AllNotesFragmentBinding.bind(view)
        setupRecycleListView()
        getNoteData()
    }

    private fun setupRecycleListView() {
        binding.notesList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = adapterNoteListAdapter
        }
    }

    private fun getNoteData() {
        viewModel.postLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is PostApiState.Success -> {
                    adapterNoteListAdapter.submitList(state.response)
                }
                is PostApiState.Error -> {
                    // Handle the error state if needed
                }
                is PostApiState.loading -> {
                    // Handle the loading state if needed
                }
            }
        }
        viewModel.getPost()
    }
}

