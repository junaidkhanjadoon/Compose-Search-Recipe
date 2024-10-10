package com.example.search.data.mappers

import Recipe
import RecipeDetails
import com.example.search.data.model.RecipeDTO

fun List<RecipeDTO>.toDomain():List<Recipe> = map {
    Recipe(
        idMeal = it.idMeal,
        strArea = it.strArea,
        strMeal = it.strMeal,
        strTags = it.strTags,
        strInstructions = it.strInstructions,
        strMealThumb = it.strMealThumb,
        strYoutube = it.strYoutube,
        strCategory = it.strCategory
    )
}


fun RecipeDTO.toDomain():RecipeDetails {
   return RecipeDetails(
        idMeal = idMeal,
        strArea = strArea,
        strMeal = strMeal,
        strTags = strTags,
        strInstructions = strInstructions,
        strMealThumb = strMealThumb,
        strYoutube = strYoutube,
        strCategory = strCategory,
        ingredeintPair = this.getIngredientsPairsWithItsMeasure()
    )
}
fun RecipeDTO.getIngredientsPairsWithItsMeasure(): List<Pair<String, String>> {
    val ingredients = listOf(
        strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5,
        strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10,
        strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15,
        strIngredient16, strIngredient17, strIngredient18, strIngredient19, strIngredient20
    )

    val measures = listOf(
        strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5,
        strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10,
        strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15,
        strMeasure16, strMeasure17, strMeasure18, strMeasure19, strMeasure20
    )

    // Filter out empty or null ingredients
    return ingredients.zip(measures).filter {
        it.first.isNotEmpty() && it.second.isNotEmpty()
    }
}
fun String?.getOrEmpty()=this?.ifEmpty { "" }?:""