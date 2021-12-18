package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ConsoleProduct {
    
    @Id
    @Column(name="id")
	private String productID;

    @Column(name = "p_name")
    private String name;

	@Column(name="p_barcode")
	private String Barcode;

	//@Column(name="id")
	//private String category;

    @Column(name="p_category")
	private String Sub_Category;

    @Column(name = "p_punit")
	private String unit;
    
	@Column(name = "p_hsn")
	private String HSN_Code;	
    
    @Column(name = "p_tax")
	private String GST;

    @Column(name = "cessp")
	private String Cess;

    @Column(name = "p_curr_stock")
	private String Current_Stock;

    @Column(name = "p_opstock")
	private String Opening_Stock;

    @Column(name = "p_pprice")
	private String Purchase_Rate;

    @Column(name = "p_srate1")
	private String Retail_Rate;

    @Column(name = "mrp")
	private String Mrp;

    @Column(name = "cost")
	private String Cost;
    
    @Column(name = "p_srate2")
	private String Whole_Rate;

    public ConsoleProduct(String productID, String name, String barcode, String sub_Category, String unit,
            String hSN_Code, String gST, String cess, String current_Stock, String opening_Stock, String purchase_Rate,
            String retail_Rate, String mrp, String cost, String whole_Rate) {
        this.productID = productID;
        this.name = name;
        Barcode = barcode;
        Sub_Category = sub_Category;
        this.unit = unit;
        HSN_Code = hSN_Code;
        GST = gST;
        Cess = cess;
        Current_Stock = current_Stock;
        Opening_Stock = opening_Stock;
        Purchase_Rate = purchase_Rate;
        Retail_Rate = retail_Rate;
        Mrp = mrp;
        Cost = cost;
        Whole_Rate = whole_Rate;
    }

    public ConsoleProduct() {
		// TODO Auto-generated constructor stub
	}

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public String getSub_Category() {
        return Sub_Category;
    }

    public void setSub_Category(String sub_Category) {
        Sub_Category = sub_Category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHSN_Code() {
        return HSN_Code;
    }

    public void setHSN_Code(String hSN_Code) {
        HSN_Code = hSN_Code;
    }

    public String getGST() {
        return GST;
    }

    public void setGST(String gST) {
        GST = gST;
    }

    public String getCess() {
        return Cess;
    }

    public void setCess(String cess) {
        Cess = cess;
    }

    public String getCurrent_Stock() {
        return Current_Stock;
    }

    public void setCurrent_Stock(String current_Stock) {
        Current_Stock = current_Stock;
    }

    public String getOpening_Stock() {
        return Opening_Stock;
    }

    public void setOpening_Stock(String opening_Stock) {
        Opening_Stock = opening_Stock;
    }

    public String getPurchase_Rate() {
        return Purchase_Rate;
    }

    public void setPurchase_Rate(String purchase_Rate) {
        Purchase_Rate = purchase_Rate;
    }

    public String getRetail_Rate() {
        return Retail_Rate;
    }

    public void setRetail_Rate(String retail_Rate) {
        Retail_Rate = retail_Rate;
    }

    public String getMrp() {
        return Mrp;
    }

    public void setMrp(String mrp) {
        Mrp = mrp;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getWhole_Rate() {
        return Whole_Rate;
    }

    public void setWhole_Rate(String whole_Rate) {
        Whole_Rate = whole_Rate;
    }

}
