// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/db/Database.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.db

// Esta classe usa o 'DatabaseDriverFactory' que criámos na Etapa 6
// para construir a instância real do banco de dados gerado pelo SQLDelight.
class Database(driverFactory: DatabaseDriverFactory) {
    private val database = MomentusDatabase(driverFactory.createDriver())

    // Expomos as "queries" (os DAOs gerados) para que o repositório possa usá-las.
    val categoriaQueries = database.categoriaQueries
    val metaQueries = database.metaQueries
    val itemCronogramaQueries = database.itemCronogramaQueries
    val templateQueries = database.templateQueries
    val templateItemQueries = database.templateItemQueries
    val habitoConcluidoQueries = database.habitoConcluidoQueries
}