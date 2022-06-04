package mangbaam.practice.parkingfree

class CampingRepository(private val dataSource: CampingRemoteDataSource) {
    fun getBaseList() = dataSource.getBasedCampingList()
    fun getKeywordList(keyword: String) = dataSource.getSearchedCampingList(keyword)
}