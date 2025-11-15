// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/data/TemplateEvent.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.data

import br.com.fabriciolima.momentus.db.Categoria
import kotlinx.serialization.Serializable

@Serializable
data class TemplateEvent(
    val titulo: String,
    val descricao: String?,
    val horarioInicio: String,
    val horarioTermino: String,
    val categoria: Categoria // Usa a classe 'Categoria'
)