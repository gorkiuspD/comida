package com.gorkius.comida.feature_dish.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
