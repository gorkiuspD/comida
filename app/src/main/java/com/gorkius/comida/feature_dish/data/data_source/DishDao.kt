package com.gorkius.comida.feature_dish.data.data_source

import androidx.room.*
import com.gorkius.comida.feature_dish.domain.model.Dish
import kotlinx.coroutines.flow.Flow

@Dao
interface DishDao {
    @Query("SELECT * FROM dish")
    fun getDishes(): Flow<List<Dish>>

    @Query("SELECT * FROM dish WHERE id = :id")
    suspend fun getDishById(id: Int): Dish?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDish(dish: Dish)

    @Delete
    suspend fun deleteDish(dish: Dish)
}