package store.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResource {

    // Singleton
    static final Map<String, ProductOut> produtos = new HashMap<String, ProductOut>();
    static {
        produtos.put("1", new ProductOut("1", "Sushi"));
        produtos.put("2", new ProductOut("2", "Temaki"));
    }

    @GetMapping("/product")
    public List<ProductOut> list() {
        return new ArrayList<>(produtos.values());
    }

    @GetMapping("/product/{id}")
    public ProductOut get(@PathVariable(required = true) String id) {
        return produtos.get(id);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable(required = true) String id) {
        produtos.remove(id);
    }

}
