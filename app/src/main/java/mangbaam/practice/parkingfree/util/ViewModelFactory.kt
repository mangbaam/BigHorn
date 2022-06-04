package mangbaam.practice.parkingfree.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mangbaam.practice.parkingfree.CampingRemoteDataSource
import mangbaam.practice.parkingfree.CampingRepository
import mangbaam.practice.parkingfree.MainViewModel
import mangbaam.practice.parkingfree.network.Network
import java.lang.IllegalArgumentException

class ViewModelFactory: ViewModelProvider.Factory {
    private val apiService = Network.getInstance()
    private val dataSource = CampingRemoteDataSource(apiService)
    private val repository = CampingRepository(dataSource)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}