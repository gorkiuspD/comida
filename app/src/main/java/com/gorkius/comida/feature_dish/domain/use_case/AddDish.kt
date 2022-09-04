package com.gorkius.comida.feature_dish.domain.use_case

import com.gorkius.comida.feature_dish.domain.model.Dish
import com.gorkius.comida.feature_dish.domain.model.InvalidDishException
import com.gorkius.comida.feature_dish.domain.repository.DishRepository
import kotlin.jvm.Throws

class AddDish(
    private val repository: DishRepository
) {
    @Throws(InvalidDishException::class)
    suspend operator fun invoke(dish: Dish){
        if(dish.name.isBlank()) {
            throw InvalidDishException("The name of the dish cannot be empty!")
        }
        repository.insertDish(dish)
    }
}