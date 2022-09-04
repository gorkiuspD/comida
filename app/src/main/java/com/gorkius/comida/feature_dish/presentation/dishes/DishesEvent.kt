package com.gorkius.comida.feature_dish.presentation.dishes

import com.gorkius.comida.feature_dish.domain.model.Dish
import com.gorkius.comida.feature_dish.domain.util.DishOrder

sealed class DishesEvent{
    data class Order(val dishOrder: DishOrder): DishesEvent()
    data class DeleteDish(val dish: Dish): DishesEvent()
    object RestoreDish: DishesEvent()
    object ToggleOrderSection : DishesEvent()
}
