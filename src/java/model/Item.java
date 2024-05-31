

package model;


public class Item {
    private ProductDBO product;
    private int quantity;
    private double price;

    public Item() {
    }

    public Item(ProductDBO product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDBO getProduct() {
        return product;
    }

    public void setProduct(ProductDBO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "product=" + product + ", quantity=" + quantity + ", price=" + price + '}';
    }
    

}
