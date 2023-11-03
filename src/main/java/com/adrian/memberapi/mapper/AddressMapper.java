package com.adrian.memberapi.mapper;

import com.adrian.memberapi.dto.AddressDTO;
import com.adrian.memberapi.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(AddressDTO addressDTO){
        Address address = new Address();
        if(address.getId() != null){
            address.setId(addressDTO.getId());
        }
        address.setStreet(addressDTO.getStreet());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setCity(addressDTO.getCity());
        return address;
    }

}
