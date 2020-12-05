package com.mipinapi.uploadings.kotlin_version.converter

import com.mipinapi.uploadings.kotlin_version.dto.CustomerDTO
import com.mipinapi.uploadings.kotlin_version.model.Customer
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class DtoToCustomer() : Converter<CustomerDTO, Customer> {

    override fun convert(dto: CustomerDTO): Customer? {
        val customer = Customer()
        customer.id = dto.id
        customer.surname = dto.surname
        customer.name = dto.name
        return customer
    }
}
