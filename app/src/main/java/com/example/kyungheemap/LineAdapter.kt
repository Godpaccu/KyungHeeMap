package com.example.kyungheemap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LineAdapter(private val lines: List<String>) : RecyclerView.Adapter<LineAdapter.LineViewHolder>() {

    inner class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lineTextView: TextView = itemView.findViewById(R.id.lineTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_line, parent, false)
        return LineViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val line = lines[position]
        holder.lineTextView.text = line

        holder.itemView.setOnClickListener {
            // 특정 라인을 클릭했을 때 수행할 동작을 여기에 작성
            // 예를 들면, 클릭된 라인의 내용을 Toast로 표시하는 등의 동작을 수행할 수 있음
        }
    }

    override fun getItemCount(): Int {
        return lines.size
    }
}