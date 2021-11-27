package com.shopperapp.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shopperapp.model.MealsRepository
import com.shopperapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository.getInstance()
) : ViewModel() {

    private val mealsJob = Job()

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    init {
        getMeals()
    }

   private fun getMeals()  = viewModelScope.launch(Dispatchers.IO) {
       mealsState.value = repository.getMeals().categories
   }

    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }

}