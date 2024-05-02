package com.stella.music

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform