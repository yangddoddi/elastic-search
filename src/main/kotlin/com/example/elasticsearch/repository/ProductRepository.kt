package com.example.elasticsearch.repository

import com.example.elasticsearch.domain.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>