// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/data/MomentusRepository.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import br.com.fabriciolima.momentus.db.* // Importa todas as queries e a classe Database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlin.coroutines.CoroutineContext

// Usamos 'open' para permitir testes e 'expect' para o CoroutineContext
expect fun getDispatcherProvider(): CoroutineContext

open class MomentusRepository(
    private val database: Database,
    private val context: CoroutineContext = getDispatcherProvider() // Para coroutines
) {
    // --- CATEGORIA (Rotina) ---
    open fun getRotinasComMetas(): Flow<List<GetRotinasComMetas>> {
        return database.categoriaQueries.getRotinasComMetas().asFlow().mapToList(context)
    }

    open fun getAllCategorias(): Flow<List<Categoria>> {
        return database.categoriaQueries.getAllCategorias().asFlow().mapToList(context)
    }

    open suspend fun insertCategoria(categoria: Categoria) {
        database.categoriaQueries.insertCategoria(
            id = categoria.id,
            nome = categoria.nome,
            duracaoPadraoMinutos = categoria.duracaoPadraoMinutos,
            cor = categoria.cor,
            descricao = categoria.descricao,
            tag = categoria.tag
        )
    }

    open suspend fun deleteCategoria(id: String) {
        database.categoriaQueries.deleteCategoria(id)
    }

    // --- META ---
    open fun getMetaParaRotina(rotinaId: String): Flow<Meta?> {
        return database.metaQueries.getMetaParaRotina(rotinaId).asFlow().mapToList(context)
            .map { it.firstOrNull() } // mapToList retorna Flow<List<Meta>>, pegamos o primeiro ou nulo
    }

    open suspend fun salvarMeta(meta: Meta) {
        database.metaQueries.insertMeta(
            rotinaId = meta.rotinaId,
            metaMinutosSemanal = meta.metaMinutosSemanal
        )
    }

    // --- ITEM CRONOGRAMA ---
    open fun getAllItensCronograma(): Flow<List<ItemCronograma>> {
        return database.itemCronogramaQueries.getAllItensCronograma().asFlow().mapToList(context)
    }

    open fun getItensRecorrentesPorDia(dia: String): Flow<List<ItemCronograma>> {
        return database.itemCronogramaQueries.getItensRecorrentesPorDia(dia).asFlow().mapToList(context)
    }

    open suspend fun insertItemCronograma(item: ItemCronograma) {
        database.itemCronogramaQueries.insertItemCronograma(
            id = item.id,
            titulo = item.titulo,
            descricao = item.descricao,
            data = item.data,
            diaDaSemana = item.diaDaSemana,
            horarioInicio = item.horarioInicio,
            horarioTermino = item.horarioTermino,
            rotinaId = item.rotinaId
        )
    }

    // ... (Implemente as outras funções: deleteItemCronograma, getStats, etc. da mesma forma)

    // --- HÁBITO CONCLUÍDO ---
    open fun getIdsConcluidos(): Flow<List<String>> {
        return database.habitoConcluidoQueries.getIdsConcluidos().asFlow().mapToList(context)
    }

    open suspend fun marcarHabitoComoConcluido(itemCronogramaId: String) {
        database.habitoConcluidoQueries.insertHabitoConcluido(
            itemCronogramaId = itemCronogramaId,
            dataConclusao = 86400L // Placeholder para timestamp
        )
    }

    open suspend fun desmarcarHabitoComoConcluido(itemCronogramaId: String) {
        database.habitoConcluidoQueries.deleteHabitoConcluido(itemCronogramaId)
    }
}