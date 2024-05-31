

package model;


public class ProductDBO {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String img;
    private double discount;
    private CategoryDBO category;
    private SupplierDBO supplier;
    private int status;

    public ProductDBO() {
    }

    public ProductDBO(int id, String name, String description, double price, int quantity, String img, double discount, CategoryDBO category, SupplierDBO supplier, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.img = img;
        this.discount = discount;
        this.category = category;
        this.supplier = supplier;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public CategoryDBO getCategory() {
        return category;
    }

    public void setCategory(CategoryDBO category) {
        this.category = category;
    }

    public SupplierDBO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDBO supplier) {
        this.supplier = supplier;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductDBO{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", img=" + img + ", discount=" + discount + ", category=" + category + ", supplier=" + supplier + ", status=" + status + '}';
    }

   
    
}