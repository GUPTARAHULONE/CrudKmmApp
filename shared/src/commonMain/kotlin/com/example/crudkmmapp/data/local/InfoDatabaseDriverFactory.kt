package com.example.crudkmmapp.data.local

import com.squareup.sqldelight.db.SqlDriver

expect class InfoDatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
