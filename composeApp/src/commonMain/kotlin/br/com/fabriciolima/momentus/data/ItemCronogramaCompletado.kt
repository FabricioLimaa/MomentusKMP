// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/data/ItemCronogramaCompletado.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.data

import br.com.fabriciolima.momentus.db.ItemCronograma // Importa a classe gerada pelo SQLDelight
import kotlinx.serialization.Serializable

@Serializable
data class ItemCronogramaCompletado(
    val item: ItemCronograma, // Usa a classe do SQLDelight
    val completado: Boolean
)