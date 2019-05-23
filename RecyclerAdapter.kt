package com.example.animopark1119.userinput

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.animopark1119.myfirstapp.Student
import kotlinx.android.synthetic.main.indview_item.view.*

class RecyclerAdapter(var activity: MainActivity?,var list:MutableList<Student>?):
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, p1: Int): MyViewHolder {

        var inflator= LayoutInflater.from(activity)
        var v=inflator.inflate(R.layout.indview_item,vg, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int= list!!.size

    override fun onBindViewHolder(mh: MyViewHolder, pos: Int) {

        var pos=list!!.get(pos)
        mh.titleObj!!.text=pos.name
        mh.descObj!!.text=pos.pass


    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        var titleObj: TextView?=null
        var descObj: TextView?=null

        init {
            titleObj=view.tvName
            descObj=view.tvDesc
            }
    }
}