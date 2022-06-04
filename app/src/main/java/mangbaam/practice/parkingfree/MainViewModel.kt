package mangbaam.practice.parkingfree

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mangbaam.practice.parkingfree.dto.Camping

class MainViewModel(private val repository: CampingRepository) : ViewModel() {
    private val _campingList = MutableLiveData<List<Camping>>()
    val campingList: LiveData<List<Camping>> = _campingList
    val keyword = MutableLiveData<String>()
    val count = MutableLiveData(0)
    val progress = MutableLiveData(false)
    private val page = MutableLiveData(1)

    init {
        getBaseList()
    }

    private fun getBaseList() {
        viewModelScope.launch {
            progress.postValue(true)
            val response = repository.getBaseList(page.value).response
            _campingList.postValue(response.body.items.item ?: emptyList())
            count.postValue(response.body.totalCount)
            progress.postValue(false)
        }
    }

    fun getSearchList() {
        viewModelScope.launch {
            progress.postValue(true)
            val k = keyword.value ?: return@launch
            val response = repository.getKeywordList(1, k).response
            _campingList.postValue(response.body.items.item ?: emptyList())
            progress.postValue(false)
        }
        progress.value = false
    }
}