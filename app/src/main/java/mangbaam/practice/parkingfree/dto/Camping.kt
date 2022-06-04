package mangbaam.practice.parkingfree.dto

import com.google.gson.annotations.SerializedName

data class Camping(
    val resultCode: Int,
    val resultMsg: String,
    val numsOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
    val contentId: Int,
    @SerializedName("facltNm") val name: String?, // 야영장 명
    val lineIntro: String?,
    val intro: String?,
    val induty: String, // 업종
    val doNm: String, // 도
    val sigunguNm: String, // 시군구
    val zipcode: Int, // 우편번호
    val addr1: String, // 주소
    val addr2: String, // 주소 상세
    val mapX: String, // 경도(X)
    val mapY: String, // 위도(Y)
    val tel: String,
    val firstImageUrl: String // 대표이미지
)
