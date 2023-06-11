package com.example.fragmentloginui.home.noteList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentloginui.R
import com.example.fragmentloginui.home.noteList.model.NoteItem

class NoteListAdapter(private val notesList :ArrayList<NoteItem>) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {


    class ViewHolder(view : View) :RecyclerView.ViewHolder(view){
        val title :TextView = view.findViewById(R.id.item_title)
        val description :TextView = view.findViewById(R.id.item_des)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val noteView = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)

        return  ViewHolder(noteView)
    }

    override fun getItemCount(): Int {
    return  notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val note = notesList[position]
        holder.title.text = note.title
        holder.description.text = note.description
    }

}
