package com.example.elasticsearch.controller

import com.example.elasticsearch.dto.RequestEditProduct
import com.example.elasticsearch.dto.RequestSaveProduct
import com.example.elasticsearch.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(
    val productService: ProductService
) {

    @PostMapping
    fun saveProduct(
        request: RequestSaveProduct
    ): Long {
        return productService.saveProduct(request)
    }

    @PatchMapping("/{productId}")
    fun editProduct(
        @PathVariable
        productId: Long,
        request: RequestEditProduct
    ): Long {
        return productService.editProduct(productId, request)
    }
}