public class Product {

    public Product(String name, float price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    private String name;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   private ProductType type;

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
