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
    @SerializedName("resveUrl") val reservation: String, // 예약
    @SerializedName("eqpmnLendCl") val equipment: String, // 장비 대여
    @SerializedName("featureNm") val feature: String,
    @SerializedName("sbrsCl") val boodae: String, // 부대 시설
    @SerializedName("sbrsEtc") val elseBoodae: String, // 부대 시설 기타
    @SerializedName("posblFcltyCl") val enjoy: String, // 주변 시설 기타
    @SerializedName("posblFcltyEtc") val enjoyElse: String, // 주변 시설 기타


):Serializable