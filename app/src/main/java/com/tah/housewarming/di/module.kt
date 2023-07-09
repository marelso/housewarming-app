package com.tah.housewarming.di

import com.tah.housewarming.data.pinterest.PinterestRemoteDataSource
import com.tah.housewarming.data.pinterest.PinterestRepository
import com.tah.housewarming.data.pinterest.PinterestService
import com.tah.housewarming.ui.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val HOUSEWARMING_API_URL = "http://10.0.11.4:8080/"
private const val HOUSEWARMING_API = "HOUSEWARMING_API"

private const val PINTEREST_API_URL = "http://widgets.pinterest.com/"
private const val PINTEREST_API = "PINTEREST_API"

private fun provideApi(url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

val module = module {
    single(named(PINTEREST_API)) { provideApi(PINTEREST_API_URL) }
    factory { get<Retrofit>(named(PINTEREST_API)).create(PinterestService::class.java) }
    factory { PinterestRemoteDataSource(get()) }
    factory { PinterestRepository(get()) }

    viewModel { DashboardViewModel(get()) }
}
