package com.android.apppedia.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apppedia.R
import com.android.apppedia.data.Application_info
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.android.apppedia.data.Application_Plus
import kotlinx.android.synthetic.main.list_related.view.*

class RelatedListAdapter(item: ArrayList<Application_Plus>, context: Context) :
    RecyclerView.Adapter<RelatedListAdapter.RelatedListViewHolder>() {

    private val items: ArrayList<Application_Plus> = item
    private val mContext : Context = context

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RelatedListAdapter.RelatedListViewHolder = RelatedListViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(
            holder: RelatedListAdapter.RelatedListViewHolder,
            position: Int
    ) {
        items[position].let { item ->
            with(holder) {
                tv_related_name.text = item.related_name
                tv_related_category.text = item.category
            }
        }
        holder.iv_related.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(items[position].related_link))
            mContext.startActivity(intent)
        }
    }

    inner class RelatedListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_related, parent, false)
    ) {
        val iv_related = itemView.iv_related
        val tv_related_name = itemView.tv_related_name
        val tv_related_category = itemView.tv_related_category

    }
}