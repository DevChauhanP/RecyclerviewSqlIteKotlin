package com.example.firt_kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firt_kt.DB.SqlDb
import com.example.firt_kt.Model.rec_model

class MainActivity : AppCompatActivity() {

//    val ed_name: EditText? = null
    lateinit var ed_name  : EditText
    lateinit var  ed_pass : EditText
    lateinit var  btn : Button
    lateinit var btn_view : Button

    var DB_HELPER : SqlDb?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_name = findViewById(R.id.ed_name)
        ed_pass = findViewById(R.id.ed_pass)
        btn = findViewById(R.id.btn)
        btn_view = findViewById(R.id.btn_show)

        DB_HELPER = SqlDb(this)

        btn.setOnClickListener {
            if(ed_name.text.isEmpty()) {
                ed_name.requestFocus()
                ed_name.setError("Enter Email")
            }
            else if(ed_pass.text.isEmpty()) {
                ed_pass.requestFocus()
                ed_pass.setError("Enter pass")
            }
            else{

                rec_model(ed_name.text.toString(),ed_pass.text.toString())


                var success: Boolean = false
                val recModel: rec_model = rec_model(ed_name.text.toString(),ed_pass.text.toString())
                success = DB_HELPER?.addData(recModel) as Boolean
                if(success){
                    Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show()
                }


            }
            

        }

        btn_view.setOnClickListener {
            val intent = Intent(this,Show_data_Activity::class.java)
            startActivity(intent)
        }

    }
}
