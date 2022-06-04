package mangbaam.practice.parkingfree.network

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import mangbaam.practice.parkingfree.dto.CampingResponse
import mangbaam.practice.parkingfree.util.Api
import mangbaam.practice.parkingfree.util.Api.BASE_URL
import mangbaam.practice.parkingfree.util.Constants.TAG
import mangbaam.practice.parkingfree.util.extension.String.isJsonArray
import mangbaam.practice.parkingfree.util.extension.String.isJsonObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

interface Network {

    @GET(Api.BASED_LIST)
    suspend fun getBaseList(
        @Query("pageNo") page: Int?,
        @Query("numOfRows") numOfRows: Int?,
        @Query("MobileOS") os: String,
        @Query("MobileApp") appName: String,
        @Query("serviceKey") key: String,
        @Query("_type") type: String,
    ): CampingResponse

    @GET(Api.SEARCH_LIST)
    suspend fun getSearchList(
        @Query("pageNo") page: Int?,
        @Query("numOfRows") numOfRows: Int?,
        @Query("MobileOS") os: String,
        @Query("MobileApp") appName: String,
        @Query("serviceKey") key: String,
        @Query("keyword") keyword: String,
        @Query("_type") type: String,
    ): CampingResponse

    companion object {
        private var retrofitService: Network? = null

        fun getInstance(): Network {
            if (retrofitService == null) {
                val client = getClient()
                retrofitService = client.create(Network::class.java)
            }
            return retrofitService!!
        }

        private fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(gsonConverterFactory())
                .build()
        }

        private fun getOkHttpClient(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor { message ->
                when {
                    message.isJsonObject() ->
                        Log.d(TAG, JSONObject(message).toString(4))
                    message.isJsonArray() ->
                        Log.d(TAG, JSONArray(message).toString(4))
                    else ->
                        Log.d(TAG, "CONNECTION INFO -> $message")
                }
            }
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor)

            return client.build()
        }

        private fun gsonConverterFactory(): GsonConverterFactory {
            val gson = GsonBuilder()
                .registerTypeAdapter(LocalDateTime::class.java, object:
                    JsonDeserializer<LocalDateTime> {
                    override fun deserialize(
                        json: JsonElement?,
                        typeOfT: Type?,
                        context: JsonDeserializationContext?
                    ): LocalDateTime {
                        return LocalDateTime.parse(json?.asString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
                    }
                })
                .registerTypeAdapter(LocalDate::class.java, object: JsonDeserializer<LocalDate> {
                    override fun deserialize(
                        json: JsonElement?,
                        typeOfT: Type?,
                        context: JsonDeserializationContext?
                    ): LocalDate {
                        return LocalDate.parse(json?.asString, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    }
                })
                .registerTypeAdapter(LocalTime::class.java, object: JsonDeserializer<LocalTime> {
                    override fun deserialize(
                        json: JsonElement?,
                        typeOfT: Type?,
                        context: JsonDeserializationContext?
                    ): LocalTime {
                        return LocalTime.parse(json?.asString, DateTimeFormatter.ofPattern("HH:mm:ss"))
                    }
                })
                .setLenient()
                .create()
            return GsonConverterFactory.create(gson)
        }
    }
}