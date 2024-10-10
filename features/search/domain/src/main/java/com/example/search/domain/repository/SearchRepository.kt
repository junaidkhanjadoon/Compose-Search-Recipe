package com.example.search.domain.repository

import Recipe
import RecipeDetails

interface SearchRepository {

 suspend fun getRecipie(s:String): Result<List<Recipe>>

 suspend fun getRecipieDetails(id:String):Result<List<RecipeDetails>>
}