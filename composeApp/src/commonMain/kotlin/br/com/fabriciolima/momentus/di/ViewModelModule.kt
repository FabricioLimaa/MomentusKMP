// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/di/ViewModelModule.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.di

import br.com.fabriciolima.momentus.viewmodel.MainViewModel
import org.koin.dsl.module

// Definimos um módulo Koin que sabe como criar nossos ViewModels
val viewModelModule = module {
    factory { MainViewModel() }
    // TODO: Adicionar os outros ViewModels (CalendarViewModel, StatsViewModel, etc.)
}