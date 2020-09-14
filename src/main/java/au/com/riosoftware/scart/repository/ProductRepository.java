package au.com.riosoftware.scart.repository;

import au.com.riosoftware.scart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByDescription(final String description);
}
