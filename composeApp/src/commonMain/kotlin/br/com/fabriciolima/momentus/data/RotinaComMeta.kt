// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/data/RotinaComMeta.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.data

import br.com.fabriciolima.momentus.db.Categoria // Importa as classes geradas
import br.com.fabriciolima.momentus.db.Meta
import kotlinx.serialization.Serializable

@Serializable
data class RotinaComMeta(
    val rotina: Categoria, // Usa a classe 'Categoria' do SQLDelight
    val meta: Meta? // Usa a classe 'Meta' do SQLDelight
)