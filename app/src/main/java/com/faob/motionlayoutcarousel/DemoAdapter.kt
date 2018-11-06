package com.faob.motionlayoutcarousel

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class DemoAdapter(private val demoList: ArrayList<DemoAdapter.Demo>) : RecyclerView.Adapter<DemoAdapter.ViewHolder>(){

    data class Demo(val item: String, val layoutId: Int)

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout) {
        val item = layout.findViewById<TextView>(R.id.item)
        var layoutId = 0

        init {
            layout.setOnClickListener {
                println("item clicked ${item.text}")
                val context = it?.context as MainActivity
                context.start(layoutId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row: ConstraintLayout = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false) as ConstraintLayout
        return ViewHolder(row);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.text = demoList[position].item
        holder.layoutId = demoList[position].layoutId
    }

    override fun getItemCount(): Int = demoList.size
}