// ARQUIVO: androidApp/src/main/java/br/com/fabriciolima/momentus/android/MomentusKMPApplication.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.android

import android.app.Application
import br.com.fabriciolima.momentus.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MomentusKMPApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Inicia o Koin quando o app for criado
        initKoin {
            androidLogger() // Logger para o Android
            androidContext(this@MomentusKMPApplication) // Fornece o contexto do Android para o Koin
        }
    }
}