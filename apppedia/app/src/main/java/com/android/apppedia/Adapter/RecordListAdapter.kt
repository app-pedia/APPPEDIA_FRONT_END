package com.android.apppedia.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apppedia.R
import com.android.apppedia.data.Record
import kotlinx.android.synthetic.main.list_record.view.*
import android.content.Context
import android.content.Intent
import com.android.apppedia.activity.SearchListActivity

class RecordListAdapter(item: ArrayList<Record>, context: Context) :
    RecyclerView.Adapter<RecordListAdapter.RecordListViewHolder>() {

    private val items: ArrayList<Record> = item
    private val mContext : Context = context

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RecordListAdapter.RecordListViewHolder = RecordListViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(
            holder: RecordListAdapter.RecordListViewHolder,
            position: Int
    ) {
        items[position].let { item ->
            with(holder) {
                tv_record.text = item.content
            }
        }
        holder.tv_record.setOnClickListener {
            val intent = Intent(mContext, SearchListActivity::class.java)
            intent.putExtra("Search", items[position].content)
            mContext.startActivity(intent)
        }
    }

    inner class RecordListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_record, parent, false)
    ) {
        val tv_record = itemView.tv_record
    }
}