package com.example.reciper
//
//import FoodApi
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.view.menu.MenuAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.squareup.picasso.Picasso
//import retrofit2.Response
//
//class MenuAdopter(private val response: List<Menu>): RecyclerView.Adapter<MenuAdopter.MenuViewHolder>() {
//
//    class MenuViewHolder(menuView : View) : RecyclerView.ViewHolder(menuView) {
//        val image = menuView.findViewById<ImageView>(R.id.menuImage)
//        val text = menuView.findViewById<TextView>(R.id.menuText)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_api,parent,false)
//        return MenuViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
//        val food =  response[position]
////        holder.text.text = food.title
////        Picasso.get().load(food.imageURL).into(holder.image)
//    }
//
//    override fun getItemCount(): Int {
//        return response.size
//    }
//
//}