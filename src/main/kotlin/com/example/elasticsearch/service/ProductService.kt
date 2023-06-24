package com.example.elasticsearch.service

import com.example.elasticsearch.domain.Product
import com.example.elasticsearch.domain.ProductImage
import com.example.elasticsearch.domain.enums.ProductState
import com.example.elasticsearch.dto.RequestEditProduct
import com.example.elasticsearch.dto.RequestSaveProduct
import com.example.elasticsearch.repository.EventRepository
import com.example.elasticsearch.repository.ProductImageRepository
import com.example.elasticsearch.repository.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductService(
    private val eventRepository: EventRepository,
    private val productImageRepository: ProductImageRepository,
    private val productRepository: ProductRepository
) {

    fun saveProduct(
        request: RequestSaveProduct
    ): Long {

        val event = eventRepository
            .findByIdOrNull(request.eventId) ?: throw IllegalArgumentException("Event not found")

        val productImages = request
            .images
            .map { ProductImage(url = it, product = null) }

        val newProduct = Product(
            name = request.name,
            price = request.price,
            productImages = productImages,
            state = ProductState.SELLABLE,
            even = event
        )

        return productRepository.save(newProduct).id!!
    }

    fun editProduct(
        productId: Long,
        request: RequestEditProduct
    ): Long {
        val product = productRepository
            .findByIdOrNull(productId) ?: throw IllegalArgumentException("Product not found")

        product.name = request.name?.let { request.name } ?: product.name
        product.price = request.price?.let { request.price } ?: product.price
        product.productImages = request
            .images
            ?.map { ProductImage(url = it, product = product) }
            ?: product.productImages

        return product.id!!
    }
}