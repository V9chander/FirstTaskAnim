package com.example.animopark1119.userinput

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.example.animopark1119.myfirstapp.Student
import kotlinx.android.synthetic.main.indview_item.view.*

class StudentAdapter(var context: Context, var slist:MutableList<Student>): BaseAdapter(){


       override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var inflater= LayoutInflater.from(context)
        var v=inflater.inflate(R.layout.indview_item,parent,false)
        var pos=slist.get(position)
        v.tvName.text=pos.name
        v.tvDesc.text=pos.pass
        return v

    }

    override fun getItem(position: Int): Any=0
    override fun getItemId(position: Int): Long =0

    override fun getCount(): Int {
        return slist.size
    }


}