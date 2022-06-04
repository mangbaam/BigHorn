package mangbaam.practice.parkingfree

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mangbaam.practice.parkingfree.dto.Camping

class MainViewModel(repository: CampingRepository): ViewModel() {
    private val _campingList = MutableLiveData<List<Camping>>()
    val campingList: LiveData<List<Camping>> = _campingList

    init {
        _campingList.postValue(repository.getBaseList())
    }
}