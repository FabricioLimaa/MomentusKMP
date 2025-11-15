// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/viewmodel/MainViewModel.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.viewmodel

import br.com.fabriciolima.momentus.data.MomentusRepository
import br.com.fabriciolima.momentus.data.RotinaComMeta
import br.com.fabriciolima.momentus.db.Categoria
import br.com.fabriciolima.momentus.db.Meta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class MainViewModel : KoinViewModel() {
    private val repository: MomentusRepository by inject()

    // --- MODIFICAÇÃO: LiveData -> StateFlow ---
    // 1. Criamos um 'MutableStateFlow' privado que podemos modificar.
    private val _rotinas = MutableStateFlow<List<RotinaComMeta>>(emptyList())
    // 2. Expomos um 'StateFlow' público e imutável para a UI observar.
    val rotinas: StateFlow<List<RotinaComMeta>> = _rotinas.asStateFlow()

    private var ultimaRotinaDeletada: Categoria? = null

    init {
        // 3. Coletamos o Flow do repositório e atualizamos nosso StateFlow.
        viewModelScope.launch {
            repository.getRotinasComMetas()
                .catch { e ->
                    // Tratar erro (ex: logar)
                }
                .collect { lista ->
                    _rotinas.value = lista
                }
        }
    }
    // --- FIM DA MODIFICAÇÃO ---

    fun addRotina(novaRotina: Categoria) = viewModelScope.launch {
        repository.insertCategoria(novaRotina)
        // A coleta do Flow acima atualizará a UI automaticamente.
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