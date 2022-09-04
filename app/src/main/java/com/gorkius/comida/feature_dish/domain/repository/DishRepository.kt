package com.gorkius.comida.feature_dish.domain.repository

import com.gorkius.comida.feature_dish.domain.model.Dish
import kotlinx.coroutines.flow.Flow

interface DishRepository {
    fun getDishes(): Flow<List<Dish>>

    suspend fun getDishById(id: Int): Dish?

    suspend fun insertDish(dish: Dish)

    suspend fun deleteDish(dish: Dish)
}