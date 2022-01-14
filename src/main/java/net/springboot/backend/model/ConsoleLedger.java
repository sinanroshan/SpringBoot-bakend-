package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsoleLedger {
    
    @Id
    @Column(name="inv")
    private String invNo;
    @Column(name="date")
    private String date;
    @Column(name="qty")
    private String qty;
    @Column(name="party")
    private String customer;
    @Column(name="party_id")
    private String c_id;
    @Column(name="rate")
    private String amound;
    @Column(name="form")
    private String type;



    public ConsoleLedger(String invNo, String date, String qty, String customer, String c_id, String amound,
            String type) {
        this.invNo = invNo;
        this.date = date;
        this.qty = qty;
        this.customer = customer;
        this.c_id = c_id;
        this.amound = amound;
        this.type = type;
    }

    public ConsoleLedger() {
		super();
		// TODO Auto-generated constructor stub
	}

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getAmound() {
        return amound;
    }

    public void setAmound(String amound) {
        this.amound = amound;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
