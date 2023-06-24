package com.example.elasticsearch.domain

import com.example.elasticsearch.domain.enums.ProductKeyword
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Keyword(
    @Id
    @Column(name = "keyword_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var keyword: String,

    @OneToMany(mappedBy = "keyword")
    var productKeyword: List<ProductKeyword> = mutableListOf()
)