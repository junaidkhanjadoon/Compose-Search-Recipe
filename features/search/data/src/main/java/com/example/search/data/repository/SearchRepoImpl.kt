package com.example.search.data.repository

import Recipe
import RecipeDetails
import com.example.search.data.mappers.toDomain
import com.example.search.data.remote.SearchApiService
import com.example.search.domain.repository.SearchRepository

class SearchRepoImpl(
    private val searchApiService: SearchApiService
) : SearchRepository {
    override suspend fun getRecipie(s: String): Result<List<Recipe>> {
        val response = searchApiService.getRecipes(s)
        return if (response.isSuccessful) {
            response.body()?.meals?.let {
                Result.success(it.toDomain())
            } ?: run {
                Result.failure(Exception("error"))
            }
        } else {
            Result.failure(Exception("Error occurred"))
        }
    }
    override suspend fun getRecipieDetails(id: String): Result<RecipeDetails> {
        val response = searchApiService.getRecipeDetail(id)
        return if (response.isSuccessful) {
            response.body()?.meals?.let {
                if (it.isNotEmpty()) {
                    Result.success(it.first().toDomain()) // Return a single RecipeDetails
                } else {
                    Result.failure(Exception("Error: No details found"))
                }
            } ?: run {
                Result.failure(Exception("Error: No details available"))
            }
        } else {
            Result.failure(Exception("Error occurred while fetching recipe details"))
        }
    }


    /*
        override suspend fun getRecipieDetails(id: String): Result<List<RecipeDetails>> {
            val response = searchApiService.getRecipeDetail(id)
            return if (response.isSuccessful) {
                response.body()?.meals?.let {
                    if (it.isNotEmpty()) {
                        Result.success(it.first().toDomain())
                    } else {
                        Result.failure(Exception("error occurred"))

                    }
                } ?: run {
                    Result.failure(Exception("error occurred"))
                }
            } else {
                Result.failure(Exception("Error occurred"))
            }
        }
    */

}