// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/db/DatabaseDriverFactory.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.db

import app.cash.sqldelight.db.SqlDriver

// Esta é a nossa "expectativa".
// O código em commonMain espera que alguém forneça esta classe.
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}