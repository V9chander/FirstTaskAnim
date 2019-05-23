package com.example.animopark1119.userinput

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.animopark1119.myfirstapp.DbHelper
import com.example.animopark1119.myfirstapp.Student
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
var db=DbHelper(this)
    var slist:MutableList<Student>?=ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        lview.adapter=StudentAdapter(this,db.readData())

        lview.setOnItemClickListener { parent, view, position, id ->
            var i= Intent(this@ShowActivity, ClickActivity::class.java)
            var m=slist!![position-1]
            i.putExtra("id",m.id)
            i.putExtra("name",m.name);
            i.putExtra("pass", m.pass)

            startActivity(i);




        }

    }
}
