package com.NewPractice.controller;

import com.NewPractice.entity.Address;
import com.NewPractice.service.Impl.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService addressService;;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/ads/{id}")  // One to One Mapping
    public ResponseEntity<?> createAddress(@RequestBody Address address, @PathVariable Long id)
    {
       Address add = addressService.createAddress(address,id);
       return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAddress(@PathVariable Long id)
    {
        Address address = addressService.getAddress(id);
        if (address!=null)
        {
            return new ResponseEntity<>(address,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not find Id ",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteAddress(@PathVariable Long id)
    {
        Address address = addressService.deteleAddress(id);
        return new ResponseEntity<>(address,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@RequestBody Address address, @PathVariable Long id)
    {
        Address address1 = addressService.updateAddress(address,id);
        if (address1!=null)
        {
            return new ResponseEntity<>(address1,HttpStatus.OK);
        }
        return new ResponseEntity<>("id is not found in this location",HttpStatus.NOT_FOUND);
    }
}
