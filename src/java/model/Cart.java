package model;

import dal.DAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;

    }

    public int getQuantityById(int id) {
        return getItemById(id).getProduct().getQuantity();
    }

    public Item getItemById(int id) {
        for (Item s : items) {
            if (s.getProduct().getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double n = 0;
        for (Item s : items) {
            if (s.getProduct().getQuantity() != 0) {
                n += s.getPrice();
            }
        }
        return n;
    }

    public void addItem(Item i) {
        if (getItemById(i.getProduct().getId()) != null) {
            Item m = getItemById(i.getProduct().getId());
            m.setQuantity(i.getQuantity() + m.getQuantity());
            m.setPrice(m.getQuantity() * i.getProduct().getPrice());

        } else {
            items.add(i);
        }
    }

    public Cart(String txt) {
        items = new ArrayList<>();
        DAO dao = new DAO();
        if (!txt.isBlank()) {
            String[] s = txt.split("@");
            for (String a : s) {
                if (!a.isEmpty()) { // Kiểm tra xem mục có giá trị không
                    String[] b = a.split(":");
                    int id = Integer.parseInt(b[0]);
                    int quantity = Integer.parseInt(b[1]);
                    ProductDBO p = dao.getProductById(id);
                    addItem(new Item(p, quantity, quantity * p.getPrice()));
                }
            }
        }
    }

    public static void main(String[] args) {
        Cart c = new Cart("1:2@2:2@2:2");
        System.out.println(c.getItems().get(1).getProduct().getPrice());
        System.out.println(c.getItems().get(1).getPrice());

    }

}
