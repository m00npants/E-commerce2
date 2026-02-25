package com.example.ecommerce.repository;

import org.example.ecommerce.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Required
    Optional<Customer> findByEmail(String email);

    List<Customer> findByLastNameIgnoreCase(String lastName);

    List<Customer> findByAddress_CityIgnoreCase(String city);

    // Optional / Advanced
    List<Customer> findByEmailContainingIgnoreCase(String keyword);

    List<Customer> findByCreatedAtAfter(Instant date);

    List<Customer> findByCreatedAtBetween(Instant start, Instant end);

    long countByAddress_CityIgnoreCase(String city);

    boolean existsByEmail(String email);
}