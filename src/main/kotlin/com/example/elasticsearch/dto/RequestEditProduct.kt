package com.example.elasticsearch.dto

data class RequestEditProduct(
    val name: String?,
    val price: Long?,
    val images: List<String>?
)
