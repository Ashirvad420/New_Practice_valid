package com.NewPractice.service.Impl;

import com.NewPractice.entity.Address;
import com.NewPractice.entity.Employee;
import com.NewPractice.repository.AddressRepository;
import com.NewPractice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private EmployeeRepository employeeRepository;

    public AddressService(AddressRepository addressRepository,EmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
    }

    // this is doing One to One Mapping
    public Address createAddress(Address address, Long id)
    {
       Employee employee = employeeRepository.findById(id).get();
       address.setEmployee(employee);
       Address asd = addressRepository.save(address);
       return asd;
    }


    // GetById
    public Address getAddress(Long id) {

        Optional<Address> Ad = addressRepository.findById(id);
        if (Ad.isPresent())
        {
            Address nes = Ad.get();
            return nes;
        }
        return null;
    }


    // Delete
    public Address deteleAddress(Long id) {
        Optional<Address> del =   addressRepository.findById(id);
        if (del.isPresent())
        {
            addressRepository.deleteById(id);
        }
        return null;
    }


    // Update
    public Address updateAddress(Address address, Long id) {
      Optional<Address> addres =  addressRepository.findById(id);
      if (addres.isPresent())
      {
          Address adds = addres.get();
          adds.setEmployee(address.getEmployee());
         Address saved = addressRepository.save(adds);
         return saved;
      }
      return null;
    }
}
