package store.product;

public class ProductModel {
    @Columnname = "id";
    private String id;
    @Columnname = "name";
    private String name;
    @Columnname = "price";
    private Double price;

    public ProductModel(Product p) {
        this.id = p.id();
        this.name = p.name();
        this.price = p.price();
    }

    public Product to() {
        return Product.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }
}
