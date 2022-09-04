package com.gorkius.comida.feature_dish.data.repository

import com.gorkius.comida.feature_dish.data.data_source.DishDao
import com.gorkius.comida.feature_dish.domain.model.Dish
import com.gorkius.comida.feature_dish.domain.repository.DishRepository
import kotlinx.coroutines.flow.Flow

class DishRepositoryImpl(
    private val dao : DishDao
) : DishRepository {
    override fun getDishes(): Flow<List<Dish>> {
        return dao.getDishes()
    }

    override suspend fun getDishById(id: Int): Dish? {
        return dao.getDishById(id)
    }

    override suspend fun insertDish(dish: Dish) {
        dao.insertDish(dish)
    }

    override suspend fun deleteDish(dish: Dish) {
        dao.deleteDish(dish)
    }
}