package com.dicoding.bangkit.android.jetpack.moviecatalogueapp.ui.home.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.Helper.setImageWithGlide
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.R
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.DataModelPojo
import java.util.*

class DataManagementAdapter(private val callback: DataCallback) :
    RecyclerView.Adapter<DataManagementAdapter.DataManagementViewHolder>() {

    private val listData = ArrayList<DataModelPojo>()

    fun setData(data: List<DataModelPojo>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
    }

    inner class DataManagementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tv_data_title: TextView = itemView.findViewById(R.id.tv_data_title)
        private val tv_data_desc: TextView = itemView.findViewById(R.id.tv_data_desc)
        private val card_item: CardView = itemView.findViewById(R.id.card_item)
        private val img_data: ImageView = itemView.findViewById(R.id.img_data)
        fun bind(data: DataModelPojo) {
            with(itemView) {
                setImageWithGlide(context, data.poster, img_data)
                tv_data_title.text = data.name
                tv_data_desc.text = data.desc

                card_item.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataManagementViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_data, parent, false)
        return DataManagementViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataManagementViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}