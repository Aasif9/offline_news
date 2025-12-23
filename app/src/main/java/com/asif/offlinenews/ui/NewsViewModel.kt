package com.asif.offlinenews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asif.offlinenews.data.model.NewsResponse
import com.asif.offlinenews.data.repository.NewsRepository
import com.asif.offlinenews.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository):ViewModel() {
    private val _newsState = MutableStateFlow<Resource<NewsResponse>>(Resource.Loading())
    val newsState:StateFlow<Resource<NewsResponse>> = _newsState

    fun fetchTopHeadlines(category: String, country:String){
        viewModelScope.launch {
            _newsState.value = Resource.Loading()
            val result = repository.getTopHeadlines(category,country)
            _newsState.value = result
        }
    }

}