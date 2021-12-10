package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat


@Entity(tableName ="item")
data class Item (

    @PrimaryKey(autoGenerate = true)
    val id :Int =0,

    @ColumnInfo(name = "name")
    val itemName :String,

    @ColumnInfo(name = "Price")
    val itemPrice :Double ,

    @ColumnInfo(name="quantity")
    val quantityInStock :Int

    )

    //** Extension function called formatted price
// takes no parameters and returns string
//**//
    fun Item.getFormattedPrice():String =
        NumberFormat.getCurrencyInstance().format(itemPrice)

