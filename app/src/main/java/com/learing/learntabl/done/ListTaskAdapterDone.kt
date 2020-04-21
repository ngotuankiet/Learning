package com.learing.learntabl.done

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learing.learntabl.R
import com.learing.learntabl.Task
import com.learing.learntabl.home.ListTaskAdapter

class ListTaskAdapterDone (
    val onClickImportant: (Task) -> Unit ={}
):RecyclerView.Adapter<ListTaskAdapterDone.TaskHolder>() {
    val listData = mutableListOf<Task>()

    inner class TaskHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvContent : TextView = view.findViewById(R.id.task_item_name_for_done)
        val btnImportant: ImageButton = view.findViewById(R.id.btn_frag_important_for_done)

        fun bind(task: Task){
            tvContent.text = task.content
            btnImportant.setImageResource(
                if(task.important) R.drawable.ic_star_important_true
                else R.drawable.ic_star_important_false
            )
            btnImportant.setOnClickListener{
                onClickImportant(task)
            }
        }
    }
    fun updateData(list: List<Task>){
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item_done,parent,false)
        return TaskHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(listData[position])
    }
    fun important(it: Task){
        val position = listData.indexOf(it)
        it.important = ! it.important
        notifyDataSetChanged()
    }
}