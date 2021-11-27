package com.shopperapp.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shopperapp.model.MealsRepository
import com.shopperapp.model.response.MealResponse
import com.shopperapp.model.response.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
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