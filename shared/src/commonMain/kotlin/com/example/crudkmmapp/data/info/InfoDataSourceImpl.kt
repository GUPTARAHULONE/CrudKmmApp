package com.example.crudkmmapp.data.info

import com.example.crudkmmapp.db.InfoDatabase
import com.example.crudkmmapp.domain.info.InfoDataSource
import database.InfoEntity

class InfoDataSourceImpl(db: InfoDatabase) : InfoDataSource {
    private val queries = db.infoQueries

    override suspend fun insertInfo(firstName: String, secondName: String, id: Long?) {
        queries.insertInfo(firstName = firstName, secondName = secondName, id = id)
    }

    override suspend fun getAllInfo(): List<InfoEntity> {
        return queries.getAllInfo().executeAsList()
    }

    override suspend fun deleteInfoById(id: Long) {
        queries.deleteInfoById(id)
    }
}
