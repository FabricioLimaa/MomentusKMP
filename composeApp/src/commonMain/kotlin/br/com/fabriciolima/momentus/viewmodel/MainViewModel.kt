// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/viewmodel/MainViewModel.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.viewmodel

import br.com.fabriciolima.momentus.data.MomentusRepository
import br.com.fabriciolima.momentus.db.Categoria
import br.com.fabriciolima.momentus.db.Meta
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class MainViewModel : KoinViewModel() {
    private val repository: MomentusRepository by inject()

    // TODO: Converter LiveData para StateFlow
    val rotinas = repository.getRotinasComMetas()

    private var ultimaRotinaDeletada: Categoria? = null

    fun addRotina(novaRotina: Categoria) = viewModelScope.launch {
        repository.insertCategoria(novaRotina)
    }

    fun deleteRotina(rotina: Categoria) = viewModelScope.launch {
        ultimaRotinaDeletada = rotina
        repository.deleteCategoria(rotina.id)
    }

    fun reinsereRotina() = viewModelScope.launch {
        ultimaRotinaDeletada?.let {
            repository.insertCategoria(it)
        }
    }

    fun salvarMeta(rotinaId: String, metaHoras: Int) = viewModelScope.launch {
        val metaMinutos = metaHoras * 60
        val novaMeta = Meta(rotinaId = rotinaId, metaMinutosSemanal = metaMinutos.toLong())
        repository.salvarMeta(novaMeta)
    }
}