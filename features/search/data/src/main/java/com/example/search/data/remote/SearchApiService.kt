package com.example.search.data.remote

import com.example.search.data.model.ReciepeResponse
import com.example.search.data.model.ReciepeResponseDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {

    @GET("api/json/v1/1/search.php")
    suspend fun getRecipes(  @Query("s") s:String) : Response<ReciepeResponse>
      //  https://www.themealdb.com/api/json/v1/1/search.php?s=chicken



    @GET("api/json/v1/1/lookup.php")
    suspend fun getRecipeDetail(@Query("i") i:String):Response<ReciepeResponseDetails>
    //www.themealdb.com/api/json/v1/1/lookup.php?i=52772
}