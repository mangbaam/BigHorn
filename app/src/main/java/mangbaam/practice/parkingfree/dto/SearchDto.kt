package mangbaam.practice.parkingfree.dto

import mangbaam.practice.parkingfree.util.Api

data class SearchDto(
    val numsOfRows: Int?, // 한 페이지 결과 수
    val pageNo: Int?, // 현재 페이지 번호
    val MobileOS: String, // AND (안드로이드)
    val MobileApp: String, // 어플명
    val ServiceKey: String = Api.KEY,
    val keyword: String, // 인코딩 필요
)