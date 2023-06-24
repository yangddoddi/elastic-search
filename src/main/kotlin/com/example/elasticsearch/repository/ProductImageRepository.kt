package com.example.elasticsearch.repository

import com.example.elasticsearch.domain.ProductImage
import org.springframework.data.jpa.repository.JpaRepository

interface ProductImageRepository : JpaRepository<ProductImage, Long>