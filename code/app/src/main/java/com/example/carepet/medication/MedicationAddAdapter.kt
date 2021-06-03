package com.example.carepet.medication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.carepet.databinding.FragmentQuantitySelectorBinding
import kotlinx.android.synthetic.main.fragment_quantity_selector.view.*


class MedicationAddAdapter{}


//class MedicationAddAdapter(
// private val fragment: Fragment,
// private val listener: OnItemClickListener
// )/* : RecyclerView.Adapter<MedicationAddAdapter.ViewHolder>()  {
//
// private var value = 1
//
//
// class ViewHolder(
// view: FragmentQuantitySelectorBinding
// ): RecyclerView.ViewHolder(view.root) {
// var takeQuantity = view.textViewQuantityValue
// val incrementQuantity = view.buttonIncrementQuantity
// val decrementQuantity = view.buttonDecrementQuantity
// }
//
// override fun onCreateViewHolder(
// parent: ViewGroup,
// viewType: Int
// ): ViewHolder {
// val binding: FragmentQuantitySelectorBinding = FragmentQuantitySelectorBinding.inflate(
// LayoutInflater.from(fragment.context), parent, false)
//
//
// return ViewHolder(binding)
// }
//
// override fun onBindViewHolder(holder: ViewHolder, position: Int) {
// holder.takeQuantity.setText(value.toString())
// }
//
// override fun getItemCount(): Int {
// return 1
// }
//
// inner class ExampleViewHolder(
// itemView: View
// ): RecyclerView.ViewHolder(itemView),
// View.OnClickListener{
// val quantityValue: TextView = itemView.textView_quantity_value
// val incrementValue: ImageView = itemView.button_increment_quantity
// val decrementValue: ImageView = itemView.button_decrement_quantity
//
// init {
// itemView.setOnClickListener(this)
// }
//
// override fun onClick(v: View?) {
// val position = adapterPosition
// if (position != RecyclerView.NO_POSITION){
// listener.onItemClick(position)
// }
// }
//
//
//
// }
//
// interface  OnItemClickListener{
// fun onItemClick(position: Int)
// }
//
// */
// //}