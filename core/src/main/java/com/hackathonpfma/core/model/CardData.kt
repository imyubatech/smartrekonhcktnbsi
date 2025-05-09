package com.hackathonpfma.core.model

data class CardData(
    val imageName: Int, // Use Int for drawable resource IDs
    val demoName: String,
    val createdDate: String,
    val ratings: Int,
    val content: String
)