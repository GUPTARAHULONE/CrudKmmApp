package com.example.crudkmmapp.domain.info

import database.InfoEntity

interface InfoDataSource {
    suspend fun insertInfo(firstName: String, secondName: String)
    suspend fun getAllInfo(): List<InfoEntity>
    suspend fun deleteInfoById(id: Long)
}
