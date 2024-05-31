package model;

import java.sql.Date;
import java.util.ArrayList;

public class OrderDBO {

    private int id;
    private Date orderDate;
    private double total;
    private int idCode;
    private String address;
    private String phone;
    private String payment;
    private String status;
    private UserDBO user;
    private ArrayList<OrderDetailDBO> listOrderDetail;

    public OrderDBO() {
        listOrderDetail = new ArrayList<>();
    }

    public OrderDBO(int id, Date orderDate, double total, int idCode, String address, String phone, String payment, String status, UserDBO user, ArrayList<OrderDetailDBO> listOrderDetail) {
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
        this.idCode = idCode;
        this.address = address;
        this.phone = phone;
        this.payment = payment;
        this.status = status;
        this.user = user;
        this.listOrderDetail = listOrderDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdCode() {
        return idCode;
    }

    public void setIdCode(int idCode) {
        this.idCode = idCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDBO getUser() {
        return user;
    }

    public void setUser(UserDBO user) {
        this.user = user;
    }

    public ArrayList<OrderDetailDBO> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(ArrayList<OrderDetailDBO> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    @Override
    public String toString() {
        return "OrderDBO{" + "id=" + id + ", orderDate=" + orderDate + ", total=" + total + ", idCode=" + idCode + ", address=" + address + ", phone=" + phone + ", payment=" + payment + ", status=" + status + ", user=" + user + ", listOrderDetail=" + listOrderDetail + '}';
    }


}
