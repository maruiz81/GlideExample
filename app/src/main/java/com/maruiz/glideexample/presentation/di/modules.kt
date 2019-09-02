package com.maruiz.glideexample.presentation.di

import com.maruiz.glideexample.data.api.BookApi
import com.maruiz.glideexample.domain.usecase.GetBooks
import com.maruiz.glideexample.presentation.adapter.BooksAdapter
import com.maruiz.glideexample.presentation.viewmodel.BooksViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(getProperty<String>("base_url"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(BookApi::class.java) }
    single { GetBooks(get()) }
    factory { BooksAdapter() }
    viewModel { BooksViewModel(get()) }
}