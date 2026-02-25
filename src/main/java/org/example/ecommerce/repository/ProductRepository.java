package org.example.ecommerce.repository;

import org.example.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_NameIgnoreCase(String categoryName);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findByNameContainingIgnoreCase(String keyword);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();

    long countByCategory_Id(Long categoryId);

    List<Product> findByCategory_Id(Long categoryId);
}

