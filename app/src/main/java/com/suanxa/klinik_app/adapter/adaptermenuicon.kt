package com.suanxa.klinik_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.suanxa.klinik_app.R
import com.suanxa.klinik_app.model.modelicon

class adaptermenuicon(
    val itemMenulist: List<modelicon>
): RecyclerView.Adapter<adaptermenuicon.MyViewHolder>(){
    class MyViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        var imgMenuicon : ImageView = itemView.findViewById(R.id.imgMenuIcon)
        var txtNamaMenu : TextView = itemView.findViewById(R.id.txtNamaMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  nView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,parent,false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemMenulist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemMenulist[position]
        holder.imgMenuicon.setImageResource(currentItem.item)
        holder.txtNamaMenu.setText(currentItem.iconName)
    }
}