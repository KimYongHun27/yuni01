package com.meta12.yuni01.service;

import com.meta12.yuni01.dto.AddressDTO;
import com.meta12.yuni01.entity.Address;
import com.meta12.yuni01.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public void setInsert(AddressDTO addressDTO)
    {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setName(addressDTO.getName());
        address.setEmail(addressDTO.getEmail());
        address.setPhone(addressDTO.getPhone());
        address.setAddress(addressDTO.getAddress());
        
        addressRepository.save(address);
    }
    public void setUpdate(AddressDTO addressDTO)
    {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setName(addressDTO.getName());
        address.setEmail(addressDTO.getEmail());
        address.setPhone(addressDTO.getPhone());
        address.setAddress(addressDTO.getAddress());

        addressRepository.save(address);

    }
    public void setDelete(AddressDTO addressDTO)
    {
        Address address = new Address();
        address.setId(addressDTO.getId());

        addressRepository.deleteById(addressDTO.getId());

    }
    public List<Address> getSelectAll()
    {
        return addressRepository.findAll();
    }
    public Address getSelectOne(Long id)
    {
        Address address = null;
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent())
        {
            address = optionalAddress.get();
        }

        return address;
    }

}
