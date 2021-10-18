package com.kay.bysykkeldata

import com.kay.bysykkeldata.data.BySykkelRepository
import com.kay.bysykkeldata.ui.BySykkelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
    single<BySykkelRepository> { BySykkelRepository() }

    viewModel {BySykkelViewModel(get())}
}