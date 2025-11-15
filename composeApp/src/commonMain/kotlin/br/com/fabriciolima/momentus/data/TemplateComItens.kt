// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/data/TemplateComItens.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.data

import br.com.fabriciolima.momentus.db.Categoria
import br.com.fabriciolima.momentus.db.Template
import br.com.fabriciolima.momentus.db.TemplateItem
import kotlinx.serialization.Serializable

@Serializable
data class TemplateComItens(
    val template: Template,
    val rotinas: List<Categoria>, // Lista de Categorias
    val itens: List<TemplateItem>
)