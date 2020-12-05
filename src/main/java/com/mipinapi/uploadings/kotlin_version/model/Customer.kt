package com.mipinapi.uploadings.kotlin_version.model

import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long = 0,

        @Column(name = "surname")
        var surname: String = "",

        @Column(name = "name")
        var name: String = ""
)
