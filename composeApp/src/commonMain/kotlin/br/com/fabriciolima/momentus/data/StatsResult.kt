// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/data/StatsResult.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.data

import kotlinx.serialization.Serializable

@Serializable
data class StatsResult(
    val nomeRotina: String,
    val corRotina: String,
    val totalMinutos: Long // SQLDelight SUM() retorna Long por padrão
)