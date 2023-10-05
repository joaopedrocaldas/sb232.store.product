package store.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductOut> list() {
        return productService.list();
    }

    @GetMapping("/product/{id}")
    public ProductOut get(@PathVariable(required = true) String id) {
        return productService.find(id);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable(required = true) String id) {
        productService.delete(id);
    }

    @PostMapping("/product")
    public void create(@RequestBody ProductIn in) {
        productService.create(in);
    }

}
