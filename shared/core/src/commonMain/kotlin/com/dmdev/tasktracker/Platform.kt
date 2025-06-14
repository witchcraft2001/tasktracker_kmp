package com.dmdev.tasktracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform