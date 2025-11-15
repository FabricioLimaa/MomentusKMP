// ARQUIVO: composeApp/src/androidMain/kotlin/br/com/fabriciolima/momentus/di/KoinAndroid.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.di

import br.com.fabriciolima.momentus.db.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

// Implementação real (actual) do 'platformModule' para Android
actual val platformModule: Module = module {
    // Diz ao Koin como criar um DatabaseDriverFactory: basta usar o contexto do app Android.
    single { DatabaseDriverFactory(get()) }
}