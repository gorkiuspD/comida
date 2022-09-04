package com.gorkius.comida.feature_dish.presentation.dishes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorkius.comida.feature_dish.domain.model.Dish
import com.gorkius.comida.feature_dish.domain.use_case.DishUseCases
import com.gorkius.comida.feature_dish.domain.util.DishOrder
import com.gorkius.comida.feature_dish.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val dishUseCases: DishUseCases
) : ViewModel(){

    private val _state = mutableStateOf(DishesState())
    val state: State<DishesState> = _state

    private var recentlyDeletedDish: Dish? = null

    private var getDishesJob: Job? = null

    init {
        getDishes(DishOrder.Name(OrderType.Descending))
    }

    fun onEvent(event: DishesEvent){
        when(event){
            is DishesEvent.Order -> {
                if(state.value.dishOrder::class == event.dishOrder::class &&
                        state.value.dishOrder.orderType == event.dishOrder.orderType){
                    return
                }

                getDishes(event.dishOrder)

            }
            is DishesEvent.DeleteDish -> {
                viewModelScope.launch {
                    dishUseCases.deleteDish(event.dish)
                    recentlyDeletedDish = event.dish
                }
            }
            is DishesEvent.RestoreDish -> {
                viewModelScope.launch {
                    dishUseCases.addDish(recentlyDeletedDish ?: return@launch)
                    recentlyDeletedDish = null
                }
            }
            is DishesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getDishes(dishOrder: DishOrder) {
        getDishesJob?.cancel()
        dishUseCases.getDishes(dishOrder)
            .onEach { dishes ->
                _state.value = state.value.copy(dishes = dishes,
                dishOrder = dishOrder
                )
            }
            .launchIn(viewModelScope)
    }
}