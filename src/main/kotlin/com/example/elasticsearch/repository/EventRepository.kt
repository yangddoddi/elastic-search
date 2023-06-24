package com.example.elasticsearch.repository

import com.example.elasticsearch.domain.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<Event, Long>