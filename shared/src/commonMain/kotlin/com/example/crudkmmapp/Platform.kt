package com.example.crudkmmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform