package com.kay.bysykkeldata

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kay.bysykkeldata.data.BySykkelApi
import com.kay.bysykkeldata.data.BySykkelRepository
import com.kay.bysykkeldata.ui.BySykkelViewModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single { BySykkelRepository(get()) }
    single<BySykkelApi> {
        val contentType = "application/json".toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gbfs.urbansharing.com/oslobysykkel.no/")
            .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory(contentType))
            .build()
        retrofit.create(BySykkelApi::class.java)
    }

    viewModel { BySykkelViewModel(get()) }
}