package com.android.apppedia.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.apppedia.R
import com.android.apppedia.data.Favorites_List
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.api.ApppediaApi
import kotlinx.android.synthetic.main.list_application.view.*
import android.content.Context
import android.content.Intent
import com.android.apppedia.activity.SearchInfoActivity
import com.android.apppedia.repository.App
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FavoritesListAdapter(item: ArrayList<Favorites_List>, context: Context) :
    RecyclerView.Adapter<FavoritesListAdapter.FavoritesListViewHolder>() {

    private val items: ArrayList<Favorites_List> = item
    private val mContext : Context = context

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): FavoritesListAdapter.FavoritesListViewHolder = FavoritesListViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(
            holder: FavoritesListAdapter.FavoritesListViewHolder,
            position: Int
    ) {
        items[position].let { item ->
            with(holder) {
                iv_application_star.setImageResource(R.drawable.apppedia_star_1)
                Glide.with(mContext).load(item.application_image_logo).into(iv_application_logo);
                tv_application_name.text = item.application_name
                tv_application_rating_average.text = item.application_rating_average
                tv_application_install_achieved.text = item.application_category
            }
        }
        holder.iv_application_star.setOnClickListener {
            NetworkCore.getNetworkCore<ApppediaApi>()
                    .requestFavoritesRemove(
                            App.prefs.TOKEN.toString(),
                            items[position].public_id
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        holder.iv_application_star.setImageResource(R.drawable.apppedia_star_0)
                    }, { except ->
                    })
        }
        holder.iv_application_logo.setOnClickListener {
            val intent = Intent(mContext, SearchInfoActivity::class.java)
            intent.putExtra("application_public_id", items[position].application_public_id)
            mContext.startActivity(intent)
        }
    }

    inner class FavoritesListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_application, parent, false)
    ) {
        val iv_application_star = itemView.iv_application_star
        val iv_application_logo = itemView.iv_application_logo
        val tv_application_name = itemView.tv_application_name
        val tv_application_rating_average = itemView.tv_application_rating_average
        val tv_application_install_achieved = itemView.tv_application_category
    }
}