package com.gorkius.comida.feature_dish.presentation.dishes

import com.gorkius.comida.feature_dish.domain.model.Dish
import com.gorkius.comida.feature_dish.domain.util.DishOrder
import com.gorkius.comida.feature_dish.domain.util.OrderType

data class DishesState(
    val dishes: List<Dish> = emptyList(),
    val dishOrder: DishOrder = DishOrder.Name(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)