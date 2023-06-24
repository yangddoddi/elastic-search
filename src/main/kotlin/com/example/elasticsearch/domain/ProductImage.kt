package com.example.elasticsearch.domain

import jakarta.persistence.*

@Entity
class ProductImage(
    @Id
    @Column(name = "product_image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var url: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product: Product?
) {
}