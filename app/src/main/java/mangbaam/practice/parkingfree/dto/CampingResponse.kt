package mangbaam.practice.parkingfree.dto

import java.io.Serializable

data class CampingResponse(
    val response: Response
): Serializable

data class Response(
    val header: Header,
    val body: Body
): Serializable

data class Header(
    val resultCode: String,
    val resultMsg: String
): Serializable

data class Body(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
): Serializable

data class Items(
    val item: List<Camping>
): Serializable