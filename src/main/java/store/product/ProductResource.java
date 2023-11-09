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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<ProductOut> list() {
        return productService.list().stream().map(ProductParser::to).toList();
    }

    @GetMapping("/{id}")
    public ProductOut get(@PathVariable(required = true) String id) {
        Product found = productService.find(id);
        return found == null ? null : ProductParser.to(found);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) String id) {
        productService.delete(id);
    }

    @PostMapping("/")
    public void create(@RequestBody ProductIn in) {
        productService.create(ProductParser.to(in));
    }

}
