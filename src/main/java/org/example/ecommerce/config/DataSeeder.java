package org.example.ecommerce.config;

import org.example.ecommerce.domain.Category;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.domain.Promotion;
import org.example.ecommerce.repository.CategoryRepository;
import org.example.ecommerce.repository.ProductRepository;
import org.example.ecommerce.repository.PromotionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;
    private final PromotionRepository promotionRepo;

    @Override
    public void run(String... args) {

        if (categoryRepo.count() == 0) {
            Category electronics = categoryRepo.save(new Category(null, "Electronics", null));
            Category books = categoryRepo.save(new Category(null, "Books", null));

            Product p1 = new Product();
            p1.setName("Laptop");
            p1.setPrice(new BigDecimal("999.99"));
            p1.setCategory(electronics);
            productRepo.save(p1);

            Product p2 = new Product();
            p2.setName("Book: Java Mastery");
            p2.setPrice(new BigDecimal("39.99"));
            p2.setCategory(books);
            productRepo.save(p2);

            Promotion promo = new Promotion();
            promo.setCode("WINTER10");
            promo.setStartDate(LocalDate.now().minusDays(1));
            promo.setEndDate(LocalDate.now().plusDays(30));
            promotionRepo.save(promo);

            p1.getPromotions().add(promo);
            productRepo.save(p1);
        }
    }
}