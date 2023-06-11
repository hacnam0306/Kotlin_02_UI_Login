package com.example.fragmentloginui.home.noteList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentloginui.R
import com.example.fragmentloginui.databinding.AllNotesFragmentBinding
import com.example.fragmentloginui.databinding.LoginFragmentBinding
import com.example.fragmentloginui.home.noteList.model.NoteItem

class AllNotesFragment : Fragment(R.layout.all_notes_fragment)  {
    private lateinit var binding:AllNotesFragmentBinding
    private lateinit var noteRecyclerView: RecyclerView
    private lateinit var noteList : ArrayList<NoteItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AllNotesFragmentBinding.bind(view)
        noteRecyclerView = binding.notesList
        noteRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        noteRecyclerView.setHasFixedSize(true)
        noteList = arrayListOf<NoteItem>()
        getNoteData()
    }

    private fun getNoteData() {
        for( i in 0..10){
            noteList.add(NoteItem("Title ne","Desciption NE"))
        }
        noteRecyclerView.adapter = NoteListAdapter(noteList)
    }
}
