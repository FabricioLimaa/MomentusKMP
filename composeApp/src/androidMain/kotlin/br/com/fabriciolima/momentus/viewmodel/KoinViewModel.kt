// ARQUIVO: composeApp/src/androidMain/kotlin/br/com/fabriciolima/momentus/viewmodel/KoinViewModel.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope as androidViewModelScope
import kotlinx.coroutines.CoroutineScope

// No Android, nosso KoinViewModel é simplesmente um ViewModel do AndroidX.
actual abstract class KoinViewModel : BaseViewModel(), CoroutineScope {
    // Mapeamos o viewModelScope do KMP para o viewModelScope do AndroidX
    override val coroutineContext = androidViewModelScope.coroutineContext

    override fun onCleared() {
        super.clear()
    }
}