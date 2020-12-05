package com.mipinapi.uploadings.kotlin_version.rest

import com.mipinapi.uploadings.kotlin_version.dto.CustomerDTO
import com.mipinapi.uploadings.kotlin_version.model.Customer
import com.mipinapi.uploadings.kotlin_version.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customer")
class CustomerRestController(private val customerService: CustomerService) {

    @GetMapping
    fun findAll() : ResponseEntity<List<Customer>> {
        val list = customerService.findAll()
        return ResponseEntity.ok(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerDTO?>? {
        val customer = customerService.findById(id)
        return ResponseEntity.ok(customer)
    }

    @PostMapping
    fun save(@RequestBody customerDTO: CustomerDTO) : ResponseEntity<CustomerDTO>? {
        return ResponseEntity.ok(customerService.save(customerDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) : String {
        customerService.deleteById(id)
        return "The category (id = $id) was deleted"
    }

}
