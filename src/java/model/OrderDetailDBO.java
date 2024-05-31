

package model;


public class OrderDetailDBO {
private int id;
private int quantity;
private double total_price;
private ProductDBO product;

    public OrderDetailDBO() {
    }

    public OrderDetailDBO(int id, int quantity, double total_price, ProductDBO product) {
        this.id = id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public ProductDBO getProduct() {
        return product;
    }

    public void setProduct(ProductDBO product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetailDBO{" + "id=" + id + ", quantity=" + quantity + ", total_price=" + total_price + ", product=" + product + '}';
    }


}