package com.android.apppedia.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apppedia.R
import android.content.Context
import com.android.apppedia.data.Functionss
import kotlinx.android.synthetic.main.list_function.view.*

class FunctionListAdapter(item: ArrayList<Functionss>, context: Context) :
    RecyclerView.Adapter<FunctionListAdapter.FunctionListViewHolder>() {

    private val items: ArrayList<Functionss> = item
    private val mContext : Context = context

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): FunctionListAdapter.FunctionListViewHolder = FunctionListViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(
            holder: FunctionListAdapter.FunctionListViewHolder,
            position: Int
    ) {
        items[position].let { item ->
            with(holder) {
                tv_function_detail.text = item.detail
            }
        }
    }

    inner class FunctionListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_function, parent, false)
    ) {
        val tv_function_detail = itemView.tv_function_detail
    }
}