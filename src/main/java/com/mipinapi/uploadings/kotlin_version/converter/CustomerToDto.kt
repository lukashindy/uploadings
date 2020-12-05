package com.mipinapi.uploadings.kotlin_version.converter

import com.mipinapi.uploadings.kotlin_version.dto.CustomerDTO
import com.mipinapi.uploadings.kotlin_version.model.Customer
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class CustomerToDto : Converter<Customer, CustomerDTO>{

    override fun convert(source: Customer): CustomerDTO? {
        val customerDTO = CustomerDTO()
        customerDTO.id = source.id
        customerDTO.surname = source.surname
        customerDTO.name = source.name
        return customerDTO
    }
}
