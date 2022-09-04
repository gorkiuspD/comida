package com.gorkius.comida.feature_dish.domain.use_case

data class DishUseCases(
    val getDishes: GetDishes,
    val deleteDish: DeleteDish,
    val addDish: AddDish
) {
}