package com.tah.housewarming.di

import com.google.gson.GsonBuilder
import com.tah.housewarming.data.PinterestService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val HOUSEWARMING_API_URL = "http://10.0.11.4:8080/"
private const val HOUSEWARMING_API = "HOUSEWARMING_API"

private const val PINTEREST_API_URL = "http://widgets.pinterest.com/"
private const val PINTEREST_API = "PINTEREST_API"

private fun provideApi(url: String): Retrofit {

    val gson = GsonBuilder().setLenient().create()

    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    return Retrofit.Builder().baseUrl(url).client(client)
        .addConverterFactory(GsonConverterFactory.create(gson)).build()
}

val module = module {
    factory(named(PINTEREST_API)) { provideApi(PINTEREST_API_URL) }
    factory { get<Retrofit>(named(PINTEREST_API)).create(PinterestService::class.java) }
}