package com.example.elasticsearch.domain

import com.example.elasticsearch.domain.enums.ProductKeyword
import com.example.elasticsearch.domain.enums.ProductState
import jakarta.persistence.*

@Entity
class Product(
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? =  null,
    var name: String,
    var price: Long,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.PERSIST])
    var productImages: List<ProductImage> = mutableListOf(),
    var state: ProductState,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    var even: Event,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.PERSIST])
    var keyword: List<ProductKeyword> = mutableListOf()
)
