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

class FavoritesVsAdapter(item: ArrayList<Favorites_List>, context: Context) :
    RecyclerView.Adapter<FavoritesVsAdapter.FavoritesListViewHolder>() {

    private val items: ArrayList<Favorites_List> = item
    private val mContext : Context = context

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): FavoritesVsAdapter.FavoritesListViewHolder = FavoritesListViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(
            holder: FavoritesVsAdapter.FavoritesListViewHolder,
            position: Int
    ) {
        items[position].let { item ->
            with(holder) {
                iv_application_star.setImageResource(R.drawable.apppedia_nemo)
                Glide.with(mContext).load(item.application_image_logo).into(iv_application_logo);
                tv_application_name.text = item.application_name
                tv_application_rating_average.text = item.application_rating_average
                tv_application_install_achieved.text = item.application_category
            }
        }
        holder.iv_application_star.setOnClickListener {
            holder.iv_application_star.setImageResource(R.drawable.apppedia_nemo_full)
            if (App.prefs.VS_ONE.toString() == "string")
            {
                App.prefs.VS_ONE = items[position].application_public_id
            }
            else if (App.prefs.VS_TWO.toString() == "string")
            {
                App.prefs.VS_TWO = items[position].application_public_id
            }
            else if (App.prefs.VS_THREE.toString() == "string")
            {
                App.prefs.VS_THREE = items[position].application_public_id
            }
            else if (App.prefs.VS_FOUR.toString() == "string")
            {
                App.prefs.VS_FOUR = items[position].application_public_id
            }
            if (App.prefs.VS_FIVE.toString() == "string")
            {
                App.prefs.VS_FIVE = items[position].application_public_id
            }
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