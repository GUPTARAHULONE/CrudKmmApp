package com.example.crudkmmapp.data.local

import com.example.crudkmmapp.db.InfoDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class InfoDatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(InfoDatabase.Schema, "info.db")
    }
}
