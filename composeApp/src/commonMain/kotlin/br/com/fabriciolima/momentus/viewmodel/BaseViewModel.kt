// ARQUIVO: composeApp/src/commonMain/kotlin/br/com/fabriciolima/momentus/viewmodel/BaseViewModel.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import org.koin.core.component.KoinComponent

// Esta é a nossa classe ViewModel multiplataforma.
// Ela não tem conhecimento do ciclo de vida do Android, mas gerencia seu próprio escopo de Coroutines.
open class BaseViewModel : KoinComponent {

    // Criamos um escopo de coroutine para este ViewModel.
    private val viewModelJob = SupervisorJob()
    protected val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    // Esta função será chamada pela UI (Android/iOS) quando o ViewModel for destruído.
    fun clear() {
        viewModelJob.cancel() // Cancela todas as coroutines
    }
}

// Criamos uma implementação 'expect' para que cada plataforma
// possa criar ViewModels de uma forma que o Koin entenda.
expect abstract class KoinViewModel() : BaseViewModel