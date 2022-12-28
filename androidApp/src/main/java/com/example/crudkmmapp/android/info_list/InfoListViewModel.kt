package com.example.crudkmmapp.android.info_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudkmmapp.domain.info.InfoDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import database.InfoEntity
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoListViewModel @Inject constructor(
    private val infoDataSource: InfoDataSource
) : ViewModel() {

    val allInfo = mutableStateOf<List<InfoEntity>>(emptyList())

    init {
        getInfo()
    }

    private fun getInfo() {
        viewModelScope.launch {
            allInfo.value = infoDataSource.getAllInfo()
        }
    }

    var firstNameText by mutableStateOf("")
        private set
    var lastNameText by mutableStateOf("")
        private set

    fun onSave() {
        if (firstNameText.isBlank() || lastNameText.isBlank()) {
            return
        }
        viewModelScope.launch {
            infoDataSource.insertInfo(firstNameText, lastNameText)
            firstNameText = ""
            lastNameText = ""
            getInfo()
        }
    }

    fun onDeleteClick(id: Long) {
        viewModelScope.launch {
            infoDataSource.deleteInfoById(id)
            getInfo()
        }
    }

    fun onFirstNameChange(value: String) {
        firstNameText = value
    }

    fun onLastNameChange(value: String) {
        lastNameText = value
    }
}
