// ARQUIVO: composeApp/src/iosMain/kotlin/br/com/fabriciolima/momentus/di/KoinIOS.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.di

import br.com.fabriciolima.momentus.db.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

// Implementação real (actual) do 'platformModule' para iOS
actual val platformModule: Module = module {
    // O driver do iOS não precisa de um contexto, então é ainda mais simples.
    single { DatabaseDriverFactory() }
}