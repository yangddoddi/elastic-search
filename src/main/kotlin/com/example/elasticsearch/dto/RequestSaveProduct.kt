package com.example.elasticsearch.dto

data class RequestSaveProduct(
    val name: String,
    val price: Long,
    val eventId: Long,
    val images: List<String>
)
