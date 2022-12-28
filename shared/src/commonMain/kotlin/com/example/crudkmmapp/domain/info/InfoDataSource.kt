package com.example.crudkmmapp.domain.info

import database.InfoEntity

interface InfoDataSource {
    suspend fun insertInfo(firstName: String, secondName: String, id: Long? = null)
    suspend fun getAllInfo(): List<InfoEntity>
    suspend fun deleteInfoById(id: Long)
}
