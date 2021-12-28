package com.shopperapp.model

import com.shopperapp.model.datasource.MealsWebService
import com.shopperapp.model.response.MealResponse
import com.shopperapp.model.response.MealsCategoriesResponse

class MealsRepository(private val mealsWebService: MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals() : MealsCategoriesResponse {
        val response = mealsWebService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMealById(mealId: String) : MealResponse? {
        return cachedMeals.firstOrNull { mealId == it.id }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }
}