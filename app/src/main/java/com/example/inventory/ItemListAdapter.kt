package com.example.inventory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.data.Item
import com.example.inventory.data.getFormattedPrice
import com.example.inventory.databinding.ItemListItemBinding as ItemListItemBinding1


//** create class Adapter and add fun colled item as object parameter in
        // in constructor  **//

 class ItemListAdapter (private val onItemClicked:(Item)-> Unit):
    ListAdapter<Item,ItemListAdapter.ItemViewHolder>(DiffCallback) {






        /// get inflate view scren
      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
return ItemViewHolder(
    ItemListItemBinding1.inflate(
        LayoutInflater.from(
            parent.context
        )

    )
)    }
            // show bles item on list
     override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
val current =getItem(position)
         holder.itemView.setOnClickListener{
             onItemClicked(current)
     }
         holder.bind(current)
     }


     class ItemViewHolder(private var binding: ItemListItemBinding1) :
         RecyclerView.ViewHolder(binding.root) {
         fun bind(item: Item) {


             ///add apply for don't rabbet binding
             binding.apply {
                 itemName.text = item.itemName
                 itemPrice.text = item.getFormattedPrice()
                 itemQuantity.text = item.quantityInStock.toString()


                 //add val on apply for liveData link item
             }


         }
     }

                /// this object in  fun compare betaine old item and new item
     companion object {
         private val DiffCallback = object: DiffUtil.ItemCallback<Item>() {
             override fun areItemsTheSame(oldItem:Item,newItem:Item):Boolean{
                 return oldItem === newItem
             }
             /// this fun compare betaine old item and new item // by using name

             override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                 return oldItem.itemName == newItem.itemName
             }
         }

     }
 }
