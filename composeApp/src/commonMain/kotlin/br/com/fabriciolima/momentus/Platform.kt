package br.com.fabriciolima.momentuskmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform