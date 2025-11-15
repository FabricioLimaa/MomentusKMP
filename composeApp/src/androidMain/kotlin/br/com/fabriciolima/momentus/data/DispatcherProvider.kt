// ARQUIVO: composeApp/src/androidMain/kotlin/br/com/fabriciolima/momentus/data/DispatcherProvider.kt
// (CÓDIGO COMPLETO)

package br.com.fabriciolima.momentus.data

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual fun getDispatcherProvider(): CoroutineContext = Dispatchers.IO