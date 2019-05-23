package com.example.animopark1119.userinput

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_click.*

class ClickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click)
        var i=intent.extras
        i.getInt("id")
        tvClickName.text=i.getString("name")
        tvClickPass.text=i.getString("pass")
    }
}
