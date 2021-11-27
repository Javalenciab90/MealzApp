package com.shopperapp.model

import android.util.Log
import com.shopperapp.model.datasource.MealsWebService
import com.shopperapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val mealsWebService: MealsWebService = MealsWebService()) {

    suspend fun getMeals() : MealsCategoriesResponse {
        return mealsWebService.getMeals()
    }
}