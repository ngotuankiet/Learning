package com.learing.learntabl.home

import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.FloatRange
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learing.learntabl.FragmentRefreshListener
import com.learing.learntabl.MainActivity
import com.learing.learntabl.R
import com.learing.learntabl.Task
import com.learing.learntabl.database.DBSQLite

class FragmentOne: Fragment(),FragmentRefreshListener {

//    lateinit var database: DBSQLite
    lateinit var arrayTask: ArrayList<Task>
    lateinit var database : DBSQLite

    lateinit var rcvListTask: RecyclerView
    lateinit var adapter: ListTaskAdapter

    private var contentX : String? =null

//    private var list : ArrayList<Task>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_one,container,false)

//        database = DBSQLite(context)
////        createDB ()
//        val content = contentX
//        if (content == null) {
//
//        } else {
//            addItemForTask(content, isDone = true, isImportant = true)
//        }
        database = DBSQLite(context)


        rcvListTask =  view.findViewById(R.id.list_task_one)
        adapter = ListTaskAdapter(
            {
                clickDone(it)
            },
            {
                clickImportant(it)
            }
        )

        val list = database.readX()
        if (list != null) {
            adapter.updateData(list)
        }

        rcvListTask.adapter = adapter
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcvListTask.layoutManager = layoutManager
//        val database = DBSQLite(context)
//        database.insertX("kiet",isDone = 1,isImportant = 1)
//        database.insertX("kiet",isDone = 1,isImportant = 1)
//        database.insertX("heh",isDone = 1,isImportant = 1)
//        database.insertX("kiet",isDone = 1,isImportant = 1)
//        database.insertX("kiet",isDone = 1,isImportant = 1)
//        val data = database.readX()
//        data.forEach{i ->
//            Log.d("check", i.content.toString())
//        }
        return  view
    }

    companion object{
        fun newInstance() : FragmentOne = FragmentOne()
    }
    private fun clickDone(it : Task){
        adapter.done(it)
    }
    private fun clickImportant(it : Task){
        adapter.important(it)
    }
//    private fun createDB(){
//        this@FragmentOne.database = DBSQLite(context,"db.sqlite",null,1)
//        this@FragmentOne.database.queryData("CREATE TABLE IF NOT EXISTS Task(Id INTEGER PRIMARY KEY AUTOINCREMENT, Content VARCHAR(200), Done INTEGER, Important INTEGER)")
//    }

//    private fun getDataTask(database: DBSQLite): ArrayList<Task>? {
//        val dataTask: Cursor = database.getData("SELECT * FROM Task")
//        val listTask = ArrayList<Task>()
//        while (dataTask.moveToNext()){
//            val content: String = dataTask.getString(1)
//            val isDone : String = dataTask.getString(2)
//            val isImportant: String = dataTask.getString(3)
//            var done = true
//            var important = true
//            done = isDone == "1"
//            important = isImportant == "1"
//            val task = Task(content,done,important)
//            listTask.add(task)
//        }
//        return listTask
//    }

//     fun  addItemForTask(content: String, isDone:Boolean,isImportant: Boolean){
//        val done : Int = if(isDone) 1
//        else 0
//        val important: Int = if(isImportant) 1
//        else 0
//
//         this@FragmentOne.database.queryData("INSERT INTO Task VALUES(null,'$content',$done,$important)")
//
//    }

//    @SuppressLint("ResourceType")
    override fun onRefresh() {
//        val content = arguments?.getString("content")
//        Log.d("check",content!!)
//        if(content != null){
//            database.insertX(content!!,isDone = 1,isImportant = 1)
//        }
    }
//

}