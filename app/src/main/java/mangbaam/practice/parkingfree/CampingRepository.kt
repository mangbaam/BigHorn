package mangbaam.practice.parkingfree

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mangbaam.practice.parkingfree.util.Constants.TAG

class CampingRepository(private val dataSource: CampingRemoteDataSource) {
    suspend fun getBaseList(page: Int? = 1) = withContext(Dispatchers.IO) {
        val ret = dataSource.getBasedCampingList(page)
        Log.d(TAG, "CampingRepository - getBaseList() called / $ret")
        ret
    }
    suspend fun getKeywordList(page: Int? = 1, keyword: String) = withContext(Dispatchers.IO) { dataSource.getSearchedCampingList(page, keyword) }
}