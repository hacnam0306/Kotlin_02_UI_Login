package com.example.fragmentloginui.home.noteList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentloginui.databinding.NoteItemBinding
import com.example.fragmentloginui.home.noteList.model.Post

private val diffPost = object : DiffUtil.ItemCallback<Post>(){
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return  oldItem == newItem
    }
}
class NoteListAdapter: ListAdapter<Post,NoteListAdapter.ViewHolder>(diffPost) {


  inner class ViewHolder(private val binding: NoteItemBinding) :RecyclerView.ViewHolder(binding.root){
    fun bindData(item:Post){
        binding.itemTitle.text = item.title
        binding.itemDes.text = item.description
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(NoteItemBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = getItem(position).let( holder::bindData)

}
