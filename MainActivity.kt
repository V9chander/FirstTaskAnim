package com.example.animopark1119.userinput

import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.animopark1119.myfirstapp.COL_DESC
import com.example.animopark1119.myfirstapp.COL_NAME
import com.example.animopark1119.myfirstapp.DbHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
var db=DbHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bLogin.setOnClickListener {
            //  val usernameEditText = findViewById(R.id.editUsername) as EditText
            if (etEmail.text.toString().equals("")) {
                Toast.makeText(this, "Plese enter a username", Toast.LENGTH_SHORT).show()
            }
            if (etPass.text.toString().equals("")) {
                Toast.makeText(this, "enter Password", Toast.LENGTH_SHORT).show()
            }
            if (!TextUtils.isEmpty(etEmail.text.toString())&& !TextUtils.isEmpty(etPass.text.toString())) {
                //var sObj = Student(etEmail.text.toString(), etPass.text.toString())
                var cv = ContentValues()
                if (!TextUtils.isEmpty(etEmail.text.toString()))
                    cv.put(COL_NAME, etEmail.text.toString())
                cv.put(COL_DESC, etPass.text.toString())

                db.insertData(cv)
                startActivity(Intent(this, ShowActivity::class.java))
            }
        }


    }
}
