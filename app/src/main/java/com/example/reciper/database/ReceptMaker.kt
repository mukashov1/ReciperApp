package com.example.reciper.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recept_table")
data class ReceptMaker(
    @PrimaryKey(autoGenerate = true)
    var FoodName:String="",
    var Ingredient:String="",
    var FoodId:Int=0
)
