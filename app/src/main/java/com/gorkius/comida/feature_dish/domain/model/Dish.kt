package com.gorkius.comida.feature_dish.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dish(
    val name: String,
    val description: String = "",
    val timestamp: Long,
    @PrimaryKey val id: Int? = null
)

class InvalidDishException(message: String): Exception(message)