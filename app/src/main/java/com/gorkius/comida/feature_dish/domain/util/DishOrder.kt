package com.gorkius.comida.feature_dish.domain.util

sealed class DishOrder(val orderType: OrderType) {
    class Name(orderType: OrderType): DishOrder(orderType)
    class Date(orderType: OrderType): DishOrder(orderType)
}