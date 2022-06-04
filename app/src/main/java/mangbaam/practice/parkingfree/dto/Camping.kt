package mangbaam.practice.parkingfree.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Camping(
    val numsOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
    val contentId: Int,
    @SerializedName("facltNm") val name: String?, // 야영장 명
    val lineIntro: String?,
    val intro: String?,
    @SerializedName("induty") val category: String, // 업종
    val doNm: String, // 도
    val sigunguNm: String, // 시군구
    val zipcode: String, // 우편번호
    val addr1: String, // 주소
    val addr2: String, // 주소 상세
    val mapX: Double, // 경도(X)
    val mapY: Double, // 위도(Y)
    val tel: String,
    @SerializedName("firstImageUrl") val thumbnail: String, // 대표 이미지
):Serializable {
    fun toSimple(): SimpleCamping {
        return SimpleCamping(
            contentId = contentId,
            name = name,
            doNm= doNm,
            sigunguNm = sigunguNm,
            thumbnail = thumbnail,
            category = category
        )
    }
}