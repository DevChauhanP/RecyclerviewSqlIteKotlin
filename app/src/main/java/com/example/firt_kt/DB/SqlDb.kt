package com.example.firt_kt.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.firt_kt.Model.rec_model

class SqlDb(context: Context) : SQLiteOpenHelper(context, SqlDb.DB_NAME, null, SqlDb.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABEL_NAME($ID INTEGER PRIMARY KEY,$NAME TEXT,$PASS TEXT);"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE ="DROP TABLE IF EXISTS $TABEL_NAME"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun addData(recModel: rec_model) : Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME,recModel.name)
        values.put(PASS,recModel.pass)
        val query = db.insert(TABEL_NAME,null,values)
        db.close()
        Log.d("mytag_d",query.toString())
        return (Integer.parseInt(query.toString())!=1)

    }

    fun showData(): ArrayList<rec_model> {

        val db = writableDatabase
        val datalist = ArrayList<rec_model>()
        val selectq = "SELECT * FROM $TABEL_NAME"
        val cusor = db.rawQuery(selectq,null)
        if(cusor!=null){
            if(cusor.moveToFirst()){
                do {

                    val model = rec_model()
                    model.name = cusor.getString(cusor.getColumnIndex(NAME))
                    model.pass = cusor.getString(cusor.getColumnIndex(PASS))
                    datalist.add(model)
                }while (cusor.moveToNext())
            }
        }
        cusor.close()
        return datalist

    }


    companion object{
        private val DB_VERSION = 1
        private val DB_NAME = "MyDATA"
        private val TABEL_NAME="DATA_TABLE"
        private val ID="ID"
        private val NAME="NAME"
        private val PASS="PASS"
    }
}