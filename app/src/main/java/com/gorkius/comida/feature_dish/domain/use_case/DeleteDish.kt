package com.gorkius.comida.feature_dish.domain.use_case

import com.gorkius.comida.feature_dish.domain.model.Dish
import com.gorkius.comida.feature_dish.domain.repository.DishRepository

class DeleteDish(
    private val repository: DishRepository
) {
    suspend operator fun invoke(dish: Dish){
        repository.deleteDish(dish)
    }
}