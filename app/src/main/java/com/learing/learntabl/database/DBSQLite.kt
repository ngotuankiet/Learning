package com.learing.learntabl.database

import android.content.ContentValues
import android.content.Context
import android.content.RestrictionEntry
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.learing.learntabl.Task
import com.learing.learntabl.home.FragmentOne

//this@FragmentOne.database.queryData("CREATE TABLE IF NOT EXISTS Task(Id INTEGER PRIMARY KEY AUTOINCREMENT, Content VARCHAR(200), Done INTEGER, Important INTEGER)")

object FeedEntry : BaseColumns {
    const val TABLE_NAME = "Task"
    const val COLUMN_NAME_CONTENT = "Content"
    const val COLUMN_NAME_DONE = "Done"
    const val COLUMN_NAME_IMPORTANT = "Important"
}
class DBSQLite(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private  val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${FeedEntry.COLUMN_NAME_CONTENT} TEXT," +
                "${FeedEntry.COLUMN_NAME_DONE} TEXT," +
                "${FeedEntry.COLUMN_NAME_IMPORTANT} INTEGER)"

    private  val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedEntry.TABLE_NAME}"

    fun insertX(content: String, isDone: Int, isImportant: Int){
        val database : SQLiteDatabase? = writableDatabase

        val values = ContentValues().apply {
            put(FeedEntry.COLUMN_NAME_CONTENT, content)
            put(FeedEntry.COLUMN_NAME_DONE, isDone)
            put(FeedEntry.COLUMN_NAME_IMPORTANT, isImportant)
        }
        database?.insert(FeedEntry.TABLE_NAME,null,values)
    }

    fun readX(): ArrayList<Task> {
        val database : SQLiteDatabase? = writableDatabase
        val dataTask: Cursor = database!!.rawQuery("SELECT * FROM Task", null)
        val listTask = ArrayList<Task>()
        while (dataTask.moveToNext()){
            val content: String = dataTask.getString(1)
            val isDone : String = dataTask.getString(2)
            val isImportant: String = dataTask.getString(3)
            var done = true
            var important = true
            done = isDone == "1"
            important = isImportant == "1"
            val task = Task(content,done,important)
            listTask.add(task)
        }

        return listTask
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "taskk.db"
    }

}