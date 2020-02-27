package com.example.kotlintest.network

import com.example.kotlintest.util.Common
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        var api_service: ApiService? = null

        fun getApiService(): ApiService? {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(interceptor)

            if (this.api_service == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Common.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
                api_service = retrofit.create(ApiService::class.java)
            }
            return api_service
        }
    }
}