package ru.itis.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springboot.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true,
    value = "select * from product join product_user pu on product.id = pu.user_id where pu.product_id = :user_id"
    )
    List<Product> findCart(Long user_id);
}
