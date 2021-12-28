package com.shopperapp.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shopperapp.model.MealsRepository
import com.shopperapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val repository: MealsRepository = MealsRepository.getInstance()

    var mealState = mutableStateOf<MealResponse?>(null)

    init {
        val mealId = savedStateHandle.get("meal_category_id") ?: ""
        getMealById(mealId)
    }

    private fun getMealById(id: String) {
        mealState.value = repository.getMealById(id)
    }
}