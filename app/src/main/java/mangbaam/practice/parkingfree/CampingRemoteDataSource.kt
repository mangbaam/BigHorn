package mangbaam.practice.parkingfree

import mangbaam.practice.parkingfree.network.Network

class CampingRemoteDataSource(private val apiService: Network) {
    fun getBasedCampingList() = apiService.getBaseList()
    fun getSearchedCampingList(keyword: String) = apiService.getSearchList(keyword)
}