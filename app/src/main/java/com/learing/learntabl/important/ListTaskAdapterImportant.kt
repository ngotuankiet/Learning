package com.learing.learntabl.important

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learing.learntabl.R
import com.learing.learntabl.Task
import com.learing.learntabl.home.ListTaskAdapter

class ListTaskAdapterImportant(
    val onClickDone: (Task) -> Unit ={}
) : RecyclerView.Adapter<ListTaskAdapterImportant.TaskHolder>(){
    val listData = mutableListOf<Task>()
    inner class TaskHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvContent : TextView = view.findViewById(R.id.task_item_name_for_important)
        val btnDone : ImageButton = view.findViewById(R.id.btn_check_done_in_important)

        fun bind(task: Task){
            tvContent.text = task.content
            btnDone.setImageResource(
                if(task.done) R.drawable.ic_check_bock_true
                else R.drawable.ic_check_bock_false
            )
            btnDone.setOnClickListener{
                onClickDone(task)
            }
        }
    }
    fun updateData(list: List<Task>){
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item_important,parent,false)
        return TaskHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(listData[position])
    }

    fun done(it: Task){
        val position = listData.indexOf(it)
        it.done = ! it.done
        notifyDataSetChanged()
    }
}