package org.example.ecommerce.repository;

import org.example.ecommerce.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    @Query("""
        SELECT p FROM Promotion p
        WHERE :date BETWEEN p.startDate AND COALESCE(p.endDate, :date)
    """)
    List<Promotion> findActiveOn(LocalDate date);

    Optional<Promotion> findByCode(String code);

    List<Promotion> findByStartDateAfter(LocalDate date);

    List<Promotion> findByEndDateBefore(LocalDate date);

    List<Promotion> findByEndDateIsNull();

    default List<Promotion> findActiveToday() {
        return findActiveOn(LocalDate.now());
    }
}
