package storeproducts.store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import storeproducts.store.model.Product;
import storeproducts.store.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity <List<Product>> getAllProduct(Product product){
        List<Product> products= productService.findAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity <Product> getProductById(@PathVariable("id") Long id){
        Product product= productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity <Product> addProduct(@RequestBody Product product){
        Product newProduct= productService.addProduct(product);
        return new ResponseEntity<>(new Product(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct (@RequestBody Product product){
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct (@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
