package mangbaam.practice.parkingfree

import mangbaam.practice.parkingfree.dto.CampingResponse
import mangbaam.practice.parkingfree.network.Network
import mangbaam.practice.parkingfree.util.Api
import mangbaam.practice.parkingfree.util.Constants.ANDROID
import mangbaam.practice.parkingfree.util.Constants.APP_NAME
import mangbaam.practice.parkingfree.util.Constants.KEY_NUMS_OF_ROWS

class CampingRemoteDataSource(private val apiService: Network) {
    suspend fun getBasedCampingList(page: Int? = 1) = apiService.getBaseList(
        page, KEY_NUMS_OF_ROWS, ANDROID, APP_NAME, Api.KEY, "json"
    )

    suspend fun getSearchedCampingList(page: Int? = 1, keyword: String): CampingResponse {
        return apiService.getSearchList(
            page, KEY_NUMS_OF_ROWS, ANDROID, APP_NAME, Api.KEY, keyword, "json"
        )
    }
}