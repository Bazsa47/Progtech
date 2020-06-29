public class Product {

    private String name;
    private float price;
    private ProductType type;

    public Product(String name, float price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
