package org.example.ecommerce.repository;

import org.example.ecommerce.domain.Order;
import org.example.ecommerce.domain.OrderStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer_Id(Long customerId);

    @EntityGraph(attributePaths = "items")
    List<Order> findByStatus(OrderStatus status);

    List<Order> findByOrderDateAfter(Instant date);

    List<Order> findByOrderDateBetween(Instant start, Instant end);

    @Query("""
        SELECT o FROM Order o
        JOIN o.items i
        WHERE i.product.id = :productId
    """)
    List<Order> findOrdersContainingProduct(Long productId);

    long countByStatus(OrderStatus status);

    List<Order> findByCustomer_IdAndStatus(Long customerId, OrderStatus status);
}
