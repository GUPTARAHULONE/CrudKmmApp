package com.example.crudkmmapp.data.local

import android.content.Context
import com.example.crudkmmapp.db.InfoDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class InfoDatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(InfoDatabase.Schema, context, "info.db")
    }
}
