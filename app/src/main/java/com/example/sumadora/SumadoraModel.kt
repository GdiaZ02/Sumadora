package com.example.sumadora
import com.example.sumadora.model.Suma


class SumadoraModel {
data class SumadoraUiState(
val valsumasList:List<Suma> = emptyList(),
val isShowingListPage: Boolean = false
)
}