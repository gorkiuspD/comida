package com.gorkius.comida.feature_dish.domain.use_case

import com.gorkius.comida.feature_dish.domain.model.Dish
import com.gorkius.comida.feature_dish.domain.repository.DishRepository
import com.gorkius.comida.feature_dish.domain.util.DishOrder
import com.gorkius.comida.feature_dish.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetDishes(
    private val repository: DishRepository
) {
    operator fun invoke(
        dishOrder: DishOrder = DishOrder.Name(OrderType.Descending)
    ): Flow<List<Dish>>{
        return repository.getDishes().map { dishes ->
            when(dishOrder.orderType){
                is OrderType.Ascending -> {
                    when(dishOrder){
                        is DishOrder.Name -> dishes.sortedBy { it.name.lowercase() }
                        is DishOrder.Date -> dishes.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when(dishOrder){
                        is DishOrder.Name -> dishes.sortedByDescending { it.name.lowercase() }
                        is DishOrder.Date -> dishes.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}