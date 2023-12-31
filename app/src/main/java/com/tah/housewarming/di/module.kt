package com.tah.housewarming.di

import com.tah.housewarming.data.Constants
import com.tah.housewarming.data.pinterest.PinterestRemoteDataSource
import com.tah.housewarming.data.pinterest.PinterestRepository
import com.tah.housewarming.data.pinterest.PinterestService
import com.tah.housewarming.ui.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private fun provideApi(url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

val pinterest = module {
    single(named(Constants.Strings.PINTEREST)) { provideApi(Constants.API.PINTEREST) }
    factory { get<Retrofit>(named(Constants.Strings.PINTEREST)).create(PinterestService::class.java) }
    factory { PinterestRemoteDataSource(get()) }
    factory { PinterestRepository(get()) }

    viewModel { DashboardViewModel(get()) }
}