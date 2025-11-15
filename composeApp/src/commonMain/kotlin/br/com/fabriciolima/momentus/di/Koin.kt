// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/di/Koin.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.di

import br.com.fabriciolima.momentus.data.MomentusRepository
import br.com.fabriciolima.momentus.db.Database
import br.com.fabriciolima.momentus.db.DatabaseDriverFactory
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

// Esta é a função principal que inicia o Koin em ambas as plataformas (Android e iOS)
fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    // --- MODIFICAÇÃO: Adicionamos o platformModule e o viewModelModule ---
    modules(appModule(), platformModule, viewModelModule)
}

// --- NOSSOS MÓDULOS DE INJEÇÃO ---

fun appModule() = module {
    // Define como criar um 'Database'. O Koin fornecerá o 'DatabaseDriverFactory'.
    single { Database(get()) }

    // Define como criar um 'MomentusRepository'. O Koin fornecerá o 'Database'.
    single { MomentusRepository(get()) }

    // TODO: Adicionar os ViewModels aqui
}


// --- PLATFORM-SPECIFIC ---

// Esperamos que cada plataforma forneça um módulo com suas dependências específicas
// (como o DatabaseDriverFactory)
expect val platformModule: Module