package com.learing.learntabl.done

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learing.learntabl.R
import com.learing.learntabl.Task

class FragmentThree: Fragment() {
    lateinit var rcvListTask: RecyclerView
    lateinit var adapter: ListTaskAdapterDone
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_three,container,false)
        rcvListTask =  view.findViewById(R.id.list_task_three)
        adapter = ListTaskAdapterDone {
            clickImportant(it)
        }

        adapter.updateData(getListTask())
        rcvListTask.adapter = adapter
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcvListTask.layoutManager = layoutManager
        return  view
    }
    companion object{
        fun newInstance() : FragmentThree = FragmentThree()
    }
    private fun clickImportant(it : Task){
        adapter.important(it)
    }
    private fun getListTask() = listOf(
        Task("ldld", done = false, important = false),
        Task("keke", done = false, important = false)
    )
}