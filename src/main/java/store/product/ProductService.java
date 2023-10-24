package store.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductOut> list(){
        return productRepository.findAll(), Spliterator.ORDERED), parllel.false
    }

    // Singleton
    static final Map<String, ProductOut> produtos = new HashMap<String, ProductOut>();
    static {
        produtos.put("1", new ProductOut("1", "Sushi", 4.5));
        produtos.put("2", new ProductOut("2", "Temaki", 8.7));
    }

    public List<ProductOut> list() {
        return produtos.values().stream().toList();
    }

    public ProductOut find(String id) {
        return produtos.get(id);
    }

    public void delete(String id) {
        produtos.remove(id);
    }

    public void create(ProductIn in) {
        final String id = UUID.randomUUID().toString();
        produtos.put(
                id,
                new ProductOut(id, in.nome(), in.preco()));
    }

}
