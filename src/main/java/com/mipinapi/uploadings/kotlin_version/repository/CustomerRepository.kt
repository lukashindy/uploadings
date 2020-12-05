package com.mipinapi.uploadings.kotlin_version.repository

import com.mipinapi.uploadings.kotlin_version.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>
