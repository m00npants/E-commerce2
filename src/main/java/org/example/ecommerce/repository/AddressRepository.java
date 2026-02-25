package com.example.ecommerce.repository;

import org.example.ecommerce.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    // Required
    List<Address> findByZipCode(String zipCode);

    // Optional / Advanced
    List<Address> findByCityIgnoreCase(String city);

    List<Address> findByStreetContainingIgnoreCase(String street);

    List<Address> findByZipCodeStartingWith(String prefix);
}