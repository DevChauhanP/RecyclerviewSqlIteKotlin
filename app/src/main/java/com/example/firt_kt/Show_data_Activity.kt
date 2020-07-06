package com.example.firt_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firt_kt.Adapter.recy_adapter
import com.example.firt_kt.DB.SqlDb
import com.example.firt_kt.Model.rec_model

class Show_data_Activity : AppCompatActivity() {

    var DB_HELPER : SqlDb?= null
    var arrayList = ArrayList<rec_model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data_)
        val rec = findViewById<RecyclerView>(R.id.recy)


//        var model = rec_model("dev","123")
//        arry.add(model)


        DB_HELPER = SqlDb(this)

       arrayList= DB_HELPER?.showData()!!


        val adapter = recy_adapter(arrayList)
        rec.layoutManager =LinearLayoutManager(this)
        rec.adapter=adapter

    }
}
