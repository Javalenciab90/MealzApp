package com.shopperapp.model

import android.util.Log
import com.shopperapp.model.datasource.MealsWebService
import com.shopperapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val mealsWebService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        return mealsWebService.getMeals().enqueue(object: Callback<MealsCategoriesResponse> {

            override fun onResponse(
                call: Call<MealsCategoriesResponse>,
                response: Response<MealsCategoriesResponse>
            ) {
                if (response.isSuccessful) {
                    successCallback(response.body())
                }
            }

            override fun onFailure(
                call: Call<MealsCategoriesResponse>,
                t: Throwable
            ) {
                // TODO later
            }
        })
    }
}