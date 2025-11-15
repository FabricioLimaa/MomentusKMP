// ARQUIVO: composeApp/src/iosMain/kotlin/br/com/fabriciolima/momentus/db/DatabaseDriverFactory.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

// Esta é a "implementação real" para iOS.
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        // Usamos o driver nativo (para iOS, macOS, etc.)
        return NativeSqliteDriver(MomentusDatabase.Schema, "Momentus.db")
    }
}