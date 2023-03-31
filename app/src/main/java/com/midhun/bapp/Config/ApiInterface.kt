package com.midhun.bapp.Config

import com.midhun.bapp.Model.Category
import com.midhun.bapp.ViewModel.CategoryViewModel
import com.midhun.bapp.ViewModel.PlaceViewModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {

//    @FormUrlEncoded
//    @POST("getStatusData")
//    fun getProduct(
//        @Header("Authorization") authorization: String,
//        @Field("table") table: String,
//        @Field("offset") offset: String,
//        @Field("pageLimit") pageLimit: String
//    ): Call<PaginationList>


    @GET("common/getcategories")
    fun getCategory(): Call<CategoryViewModel>

    @GET("common/getplaces")
    fun getPlace(): Call<PlaceViewModel>

    companion object {

        var BASE_URL = "https://buzapi.businezapp.com/public/v1/"
        var API_KEY =  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Ikhhd2tzIFNvbHV0aW9ucyIsImFkbWluIjp0cnVlfQ.B5RoeVIIAVuLBbkq_yCFoZMmy4gXmiaIF-tSM3yPzQM"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}