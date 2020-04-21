package com.learing.learntabl.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.learing.learntabl.home.FragmentOne

class DBSQLite(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    //CUID
    fun queryData(sql: String){
        val database : SQLiteDatabase = writableDatabase
        database.execSQL(sql)
    }
    //SELECT
    fun getData(sql: String):Cursor{
        val database: SQLiteDatabase = readableDatabase
        return database.rawQuery(sql,null)
    }

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}