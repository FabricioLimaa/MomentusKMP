// ARQUIVO: composeApp/src/androidMain/kotlin/br/com/fabriciolima/momentus/db/DatabaseDriverFactory.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

// Esta é a "implementação real" para Android.
// Usamos 'actual' para dizer que estamos cumprindo a 'expect'.
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        // Usamos o driver específico do Android
        return AndroidSqliteDriver(MomentusDatabase.Schema, context, "Momentus.db")
    }
}