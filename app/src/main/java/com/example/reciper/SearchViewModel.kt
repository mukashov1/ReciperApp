package com.example.reciper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reciper.API.Menu
import com.example.reciper.API.SearchApi
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    private val _properties = MutableLiveData<Menu>()

    val properties: LiveData<Menu>
        get() = _properties

    private val _property = MutableLiveData<Menu.MenuItem>()

    val property: LiveData<Menu.MenuItem>
        get() = _property

    init {
        getFoodProperties()
    }

    private fun getFoodProperties() {
        viewModelScope.launch {
            try {
                val listResult = SearchApi.retrofitService.getProperties().menuItems
                _response.value = "Success: ${listResult.size} Mars properties retrieved"
                if (listResult.size > 0) {
                    _property.value = listResult[0]
                }


            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }


    private var _favList = mutableListOf<Food>()
    val favList: MutableList<Food>
        get() = _favList

    private var ingredientList = arrayListOf(
        Ingredient("2 - stick unsalted butter") ,
        Ingredient("3 - English muffins, opened"),
        Ingredient("6 - Eggs, plus 3 egg yolks, divided"),
        Ingredient("2 - Tablespoons lemon juice"),
        Ingredient("3 - English muffins, opened"),
        Ingredient("3 - English muffins, opened"),
        Ingredient("3 - English muffins, opened"),)

    private var _foodList = arrayListOf(
    Food("Pizza" , "false" , "The classic pile-up" , ingredientList),
    Food("Pizza2" , "false" , "The classic pile-up" , ingredientList),
    Food("Pizza3" , "false" , "The classic pile-up" , ingredientList),
    Food("Pizza4" , "false" , "The classic pile-up" , ingredientList),)

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