package com.mipinapi.uploadings.kotlin_version.service

import com.mipinapi.uploadings.kotlin_version.converter.CustomerToDto
import com.mipinapi.uploadings.kotlin_version.converter.DtoToCustomer
import com.mipinapi.uploadings.kotlin_version.dto.CustomerDTO
import com.mipinapi.uploadings.kotlin_version.model.Customer
import com.mipinapi.uploadings.kotlin_version.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository,
                      private val customerToDto: CustomerToDto,
                      private val dtoToCustomer: DtoToCustomer) {

    fun findAll(): List<Customer> {
        return customerRepository.findAll()
    }

    private fun findByIdEntity(id: Long): Customer {
        return customerRepository.findById(id).orElse(null)
    }

    fun findById(id: Long): CustomerDTO? {
        return customerToDto.convert(findByIdEntity(id))
    }

    fun save(customerDTO: CustomerDTO): CustomerDTO? {
        val customer: Customer? = dtoToCustomer.convert(customerDTO)
        val savedCustomer : Customer? = customerRepository.save(customer)
        return savedCustomer?.let { customerToDto.convert(it) }
    }

    fun deleteById(id: Long) {
        customerRepository.deleteById(id)
    }
}
