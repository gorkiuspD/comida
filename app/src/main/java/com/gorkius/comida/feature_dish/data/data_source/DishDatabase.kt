package com.gorkius.comida.feature_dish.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gorkius.comida.feature_dish.domain.model.Dish

@Database(
    entities = [Dish::class],
    version = 1
)
abstract class DishDatabase: RoomDatabase() {
    abstract val dishDao: DishDao

    companion object{
        const val DATABASE_NAME = "dishes_db"
    }
}