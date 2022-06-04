package mangbaam.practice.parkingfree.dto

import com.google.gson.annotations.SerializedName

data class SimpleCamping(
    val contentId: Int,
    @SerializedName("facltNm") val name: String?, // 야영장 명
    val doNm: String, // 도
    val sigunguNm: String, // 시군구
    @SerializedName("firstImageUrl") val thumbnail: String?, // 대표 이미지
    @SerializedName("induty") val category: String // 업종
)