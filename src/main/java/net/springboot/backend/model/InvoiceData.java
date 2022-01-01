package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InvoiceData {
    
    @Id
    @Column(name = "si_no")
	private String si;
    @Column(name = "invno")
	private String invno;
    @Column(name = "pid")
    private String pId;
    @Column(name = "pname")
    private String pName;
    @Column(name = "pqty")
	private String qty;
    @Column(name = "pcategory")
    private String category;
    @Column(name = "price")
    private String price;
    @Column(name = "mrp")
	private String mrp;
    @Column(name = "tprice")
    private String Tprice;
    @Column(name = "order_status")
    private String Status;

    public InvoiceData(String si, String invno, String pId, String pName, String qty, String category, String price,
            String mrp, String tprice, String status) {
        this.si = si;
        this.invno = invno;
        this.pId = pId;
        this.pName = pName;
        this.qty = qty;
        this.category = category;
        this.price = price;
        this.mrp = mrp;
        Tprice = tprice;
        Status = status;
    }
    public InvoiceData() {
		super();
		// TODO Auto-generated constructor stub
	}
    public String getSi() {
        return si;
    }
    public void setSi(String si) {
        this.si = si;
    }
    public String getInvno() {
        return invno;
    }
    public void setInvno(String invno) {
        this.invno = invno;
    }
    public String getpId() {
        return pId;
    }
    public void setpId(String pId) {
        this.pId = pId;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }
    public String getQty() {
        return qty;
    }
    public void setQty(String qty) {
        this.qty = qty;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getMrp() {
        return mrp;
    }
    public void setMrp(String mrp) {
        this.mrp = mrp;
    }
    public String getTprice() {
        return Tprice;
    }
    public void setTprice(String tprice) {
        Tprice = tprice;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

}
