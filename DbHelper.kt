package com.example.animopark1119.myfirstapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DB_VERSION = 1
val DB_NAME = "MyTasks"
val TABLE_NAME = "Tasks"
val ID = "Id"
val COL_NAME = "Name"
val COL_DESC = "Desc"

class DbHelper(var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
                ID + " INTEGER PRIMARY KEY," +
                COL_NAME + " TEXT," + COL_DESC + " TEXT)"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }



    fun insertData(cv:ContentValues):Long {
        //cv.put(COL_NAME,s.name)
        //cv.put(COL_DESC,s.pass)
    var db=this.writableDatabase
        var status=db.insert(TABLE_NAME,null,cv)
    if (status==-1L)
        Toast.makeText(context,"insertion Failed",Toast.LENGTH_LONG).show()
        else
        Toast.makeText(context,"Sucess ",Toast.LENGTH_LONG).show()
        return status
    }

    fun readData():MutableList<Student>{

        var tlist:MutableList<Student>?=ArrayList()
       // qb.tables= TABLE_NAME
        val db = this.readableDatabase
        //val query = "Select * from " + TABLE_NAME
        val cursor = db.query(TABLE_NAME, null,null,null,null,null,null,null)
        tlist!!.clear()
        if(cursor.moveToFirst()){
            do {
                var user = Student()
                user.id = cursor.getInt(cursor.getColumnIndex(ID))
                user.name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                user.pass = cursor.getString(cursor.getColumnIndex(COL_DESC))
                tlist.add(user)
            }while (cursor.moveToNext())
        }
        cursor.close()

        return tlist!!
        db.close()
    }



}
