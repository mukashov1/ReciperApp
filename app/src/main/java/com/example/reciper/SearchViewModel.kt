package com.example.reciper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reciper.API.Recipe
import com.example.reciper.databinding.FragmentSearchBinding
import kotlinx.coroutines.launch

class SearchViewModel(): ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    private val _properties = MutableLiveData<Recipe>()

    val properties: LiveData<Recipe>
        get() = _properties

    private val _property = MutableLiveData<Recipe.Result>()

    val property: LiveData<Recipe.Result>
        get() = _property

    init {
        getFoodProperties()
    }

    fun getFoodProperties() {
        viewModelScope.launch {
        println(SearchApi.retrofitService.getProperties())
            try {
                val listResult = SearchApi.retrofitService.getProperties().results
                    println("FFFFFFFF")
                _response.value = "Success: ${listResult.size} Mars properties retrieved"
                if (listResult.size > 0) {
                    _property.value = listResult[0]
                    var recipe = listResult[0]
                    for (i in listResult.indices) {
                        recipe = listResult[i]
                        _foodList.add(0,Food(recipe.title,"false",recipe.summary, setIngredient(recipe.extendedIngredients),recipe.image))
                    }
                    println(foodList)
                }


            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    private fun setIngredient(list: List<Recipe.Result.ExtendedIngredient>): ArrayList<Ingredient> {
        val ingredient = arrayListOf<Ingredient>()
        for (element in list) {
            ingredient.add(Ingredient(element.original))
        }

        return ingredient
    }


    private var _favList = mutableListOf<Food>()
    val favList: MutableList<Food>
        get() = _favList

//    private var ingredientList = arrayListOf(
//        Ingredient("2 - stick unsalted butter") ,
//        Ingredient("3 - English muffins, opened"),
//        Ingredient("6 - Eggs, plus 3 egg yolks, divided"),
//        Ingredient("2 - Tablespoons lemon juice"),
//        Ingredient("3 - English muffins, opened"),
//        Ingredient("3 - English muffins, opened"),
//        Ingredient("3 - English muffins, opened"),)

    private var _foodList = arrayListOf<Food>()

    val foodList: ArrayList<Food>
        get() = _foodList

    fun addToFav(food: Food) {
        var favFood1 = food.copy(isFavorite = "true")
        if (!_favList.contains(favFood1))  {
            _favList.add(favFood1)
        }
        _foodList[_foodList.indexOf(food)].isFavorite == "true"
        println(_favList)
    }

    fun removeFromFav(food: Food) {
            var favFood2 = food.copy(isFavorite = "true")
        if (_favList.contains(favFood2))  {
            _favList.remove(favFood2)
        }
        _foodList[_foodList.indexOf(food)].isFavorite == "false"

        println(_favList)
    }
}