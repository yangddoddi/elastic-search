package com.example.elasticsearch.domain.enums

import com.example.elasticsearch.domain.Keyword
import com.example.elasticsearch.domain.Product
import jakarta.persistence.*

@Entity
class ProductKeyword(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product,
    @ManyToOne
    @JoinColumn(name = "keyword_id")
    var keyword: Keyword
) {
}