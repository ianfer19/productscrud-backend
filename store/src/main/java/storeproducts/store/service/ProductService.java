package storeproducts.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import storeproducts.store.exception.ProductNotFoundException;
import storeproducts.store.model.Product;
import storeproducts.store.repo.ProductRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct (Product product){
        product.setProductCode(UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public Product findProductById (Long id){
       return productRepo.findProductById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product of id" + id + "Was not found"));
    }

    public void deleteProduct (Long id){
        productRepo.deleteProductById(id);
    }
}
