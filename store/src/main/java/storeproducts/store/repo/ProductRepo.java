package storeproducts.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import storeproducts.store.model.Product;

import java.util.Optional;

public interface ProductRepo extends JpaRepository <Product, Long>{

    void deleteProductById(Long id);

    Optional<Product> findProductById(Long id);
}
