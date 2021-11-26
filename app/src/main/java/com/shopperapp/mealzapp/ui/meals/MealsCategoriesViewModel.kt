package com.shopperapp.mealzapp.ui.meals

import android.util.Log
import androidx.lifecycle.ViewModel
import com.shopperapp.model.MealsRepository
import com.shopperapp.model.response.MealResponse
import com.shopperapp.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {

    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}