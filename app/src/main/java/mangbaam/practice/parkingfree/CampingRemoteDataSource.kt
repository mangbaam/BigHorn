package mangbaam.practice.parkingfree

import android.util.Log
import mangbaam.practice.parkingfree.dto.CampingResponse
import mangbaam.practice.parkingfree.network.Network
import mangbaam.practice.parkingfree.util.Api
import mangbaam.practice.parkingfree.util.Constants.ANDROID
import mangbaam.practice.parkingfree.util.Constants.APP_NAME
import mangbaam.practice.parkingfree.util.Constants.KEY_NUMS_OF_ROWS
import mangbaam.practice.parkingfree.util.Constants.TAG

class CampingRemoteDataSource(private val apiService: Network) {
    suspend fun getBasedCampingList(page: Int? = 1): CampingResponse {
        val ret =apiService.getBaseList(
            page, KEY_NUMS_OF_ROWS, ANDROID, APP_NAME, Api.KEY, "json"
        )
        Log.d(TAG, "CampingRemoteDataSource - getBasedCampingList() called / $ret")
        return ret
    }

    suspend fun getSearchedCampingList(page: Int? = 1, keyword: String): CampingResponse {
        val encodedKeyword = keyword.toByteArray(Charsets.UTF_8)
        return apiService.getSearchList(
            page, KEY_NUMS_OF_ROWS, ANDROID, APP_NAME, Api.KEY, encodedKeyword, "json"
        )
    }
}