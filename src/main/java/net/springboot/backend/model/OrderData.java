package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderData {

    @Id
    @Column(name = "inv_no")
	private String invno;
    @Column(name = "c_id")
    private String customerID;
    @Column(name = "total_amount")
    private String totalAmound;
    @Column(name = "prod_qty")
    private String orderQty;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "c_fullname")
    private String c_FullName;
    @Column(name = "c_phone")
    private String c_phone;
    @Column(name = "c_place")
    private String c_place;
    @Column(name = "c_home_no")
    private String c_home;
    @Column(name = "c_pin")
    private String c_pin;
    @Column(name = "c_landmark")
    private String c_landmark;
    @Column(name = "c_city")
    private String c_City;
    @Column(name = "order_status")
    private String orderStatus;

    public OrderData(String invno, String customerID, String totalAmound, String orderQty, String orderDate,
            String c_FullName, String c_phone, String c_place, String c_home, String c_pin, String c_landmark,
            String c_City, String orderStatus) {
        this.invno = invno;
        this.customerID = customerID;
        this.totalAmound = totalAmound;
        this.orderQty = orderQty;
        this.orderDate = orderDate;
        this.c_FullName = c_FullName;
        this.c_phone = c_phone;
        this.c_place = c_place;
        this.c_home = c_home;
        this.c_pin = c_pin;
        this.c_landmark = c_landmark;
        this.c_City = c_City;
        this.orderStatus = orderStatus;
    }
    public OrderData() {
		super();
		// TODO Auto-generated constructor stub
	}
    public String getInvno() {
        return invno;
    }
    public void setInvno(String invno) {
        this.invno = invno;
    }
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getTotalAmound() {
        return totalAmound;
    }
    public void setTotalAmound(String totalAmound) {
        this.totalAmound = totalAmound;
    }
    public String getOrderQty() {
        return orderQty;
    }
    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getC_FullName() {
        return c_FullName;
    }
    public void setC_FullName(String c_FullName) {
        this.c_FullName = c_FullName;
    }
    public String getC_phone() {
        return c_phone;
    }
    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }
    public String getC_place() {
        return c_place;
    }
    public void setC_place(String c_place) {
        this.c_place = c_place;
    }
    public String getC_home() {
        return c_home;
    }
    public void setC_home(String c_home) {
        this.c_home = c_home;
    }
    public String getC_pin() {
        return c_pin;
    }
    public void setC_pin(String c_pin) {
        this.c_pin = c_pin;
    }
    public String getC_landmark() {
        return c_landmark;
    }
    public void setC_landmark(String c_landmark) {
        this.c_landmark = c_landmark;
    }
    public String getC_City() {
        return c_City;
    }
    public void setC_City(String c_City) {
        this.c_City = c_City;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
