package com.learing.learntabl.important

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learing.learntabl.R
import com.learing.learntabl.Task
import com.learing.learntabl.home.ListTaskAdapter as ListTaskAdapter1

class FragmentTwo: Fragment() {
    lateinit var rcvListTask: RecyclerView
    lateinit var adapter: ListTaskAdapterImportant

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_two,container,false)
        rcvListTask =  view.findViewById(R.id.list_task_two)
        adapter = ListTaskAdapterImportant {
            clickDone(it)
        }

        adapter.updateData(getListTask())
        rcvListTask.adapter = adapter
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcvListTask.layoutManager = layoutManager

        return  view
    }
    companion object{
        fun newInstance() : FragmentTwo =
            FragmentTwo()
    }
    private fun clickDone(it : Task){
        adapter.done(it)
    }
    private fun getListTask() = listOf(
        Task("ldld", done = false, important = false),
        Task("keke", done = false, important = false)
    )
}