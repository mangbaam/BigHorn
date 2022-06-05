package mangbaam.practice.parkingfree

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mangbaam.practice.parkingfree.dto.Camping
import mangbaam.practice.parkingfree.util.Constants.TAG

class MainViewModel(private val repository: CampingRepository) : ViewModel() {
    private val _campingList = MutableLiveData<List<Camping>>()
    val campingList: LiveData<List<Camping>> = _campingList
    val keyword = MutableLiveData<String>()
    val count = MutableLiveData(0)
    val progress = MutableLiveData(false)
    val page = MutableLiveData(1)
    val searchMode = MutableLiveData(false)

    init {
        getBaseList()
    }

    private fun getBaseList() {
        viewModelScope.launch {
            progress.postValue(true)
            val response = repository.getBaseList(page.value).response
            response.body.items ?: return@launch
            _campingList.postValue(response.body.items.item?: return@launch)

            count.postValue(response.body.totalCount)
            progress.postValue(false)
        }
    }

    fun getSearchList() {
        viewModelScope.launch {
            progress.postValue(true)
            val k = keyword.value ?: return@launch
            val response = repository.getKeywordList(page.value, k).response
            response.body.items ?: return@launch
            Log.d(TAG, "MainViewModel - getSearchList() called / $response")
            _campingList.postValue(response.body.items.item?: return@launch)
            progress.postValue(false)
        }
        progress.value = false
    }
}