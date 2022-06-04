package mangbaam.practice.parkingfree.dto

import mangbaam.practice.parkingfree.util.Api

data class LocationBasedDto(
    val numsOfRows: Int?, // 한 페이지 결과 수
    val pageNo: Int?, // 현재 페이지 번호
    val MobileOS: String, // AND (안드로이드)
    val MobileApp: String, // 어플명
    val ServiceKey: String = Api.KEY,
    val mapX: Int, // 경도
    val mapY: Int, // 위도
    val radius: Int, // 거리 반경(m)
)
