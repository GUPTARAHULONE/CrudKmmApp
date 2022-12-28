package com.example.crudkmmapp.android.info_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import database.InfoEntity

@Composable
fun InfoListScreen(
    viewModel: InfoListViewModel = hiltViewModel()
) {
    val info = viewModel.allInfo.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(info) { it ->
                    InfoItem(
                        infoDetails = it,
                        onDeleteClick = {
                            viewModel.onDeleteClick(it.id)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = viewModel.firstNameText,
                    onValueChange = viewModel::onFirstNameChange,
                    placeholder = {
                        Text(text = "First name")
                    },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextField(
                    value = viewModel.lastNameText,
                    onValueChange = viewModel::onLastNameChange,
                    placeholder = {
                        Text(text = "Last name")
                    },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = viewModel::onSave) {
                    Icon(
                        imageVector = Icons.Outlined.Done,
                        contentDescription = "Insert Info",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun InfoItem(
    infoDetails: InfoEntity,
    onDeleteClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = infoDetails.firstName + " " + infoDetails.secondName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(onClick = onDeleteClick) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "Delete Info",
                tint = Color.Gray
            )
        }
    }
}
