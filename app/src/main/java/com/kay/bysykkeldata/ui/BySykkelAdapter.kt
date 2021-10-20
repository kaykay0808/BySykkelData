package com.kay.bysykkeldata.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kay.bysykkeldata.databinding.RowLayoutBinding

class BySykkelAdapter: RecyclerView.Adapter<BySykkelAdapter.MyViewHolder>() {

    var dataList = emptyList<BySykkelUiModel>()

    class MyViewHolder(val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return MyViewHolder(RowLayoutBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.stasjonsnavn.text = dataList[position].stationName
        holder.binding.antallLedigeSykler.text = dataList[position].numberOfBikes.toString()
        holder.binding.antallLedigeDocks.text = dataList[position].numberOfDocks.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    // not sure if iam gonna use this function
    fun setData(bySykkelUiModel: List<BySykkelUiModel>){
        this.dataList = bySykkelUiModel
        notifyDataSetChanged()
    }
}