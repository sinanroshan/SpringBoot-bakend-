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
	private Integer productID;

    @Column(name = "p_name")
    private String name;

	@Column(name="p_barcode")
	private String barcode;

	@Column(name="p_godown")
	private String category;

    @Column(name="p_category")
	private String sub_Category;

    @Column(name = "p_unit")
	private String unit;
    
	@Column(name = "p_hsn")
	private String hsn_Code;	
    
    @Column(name = "p_tax")
	private String gst;

    @Column(name = "cessp")
	private Integer cess;

    @Column(name = "p_curr_stock")
	private String current_Stock;

    @Column(name = "p_opstock")
	private String opening_Stock;

    @Column(name = "p_pprice")
	private String purchase_Rate;

    @Column(name = "p_srate1")
	private String retail_Rate;

    @Column(name = "mrp")
	private String mrp;

    @Column(name = "cost")
	private String cost;
    
    @Column(name = "p_srate2")
	private String whole_Rate;

    @Column(name = "p_discription")
    private String discription;

    @Column(name = "p_photo")
    private String KeyImage;

    @Column(name = "p_photo1")
    private String image1;

    @Column(name = "p_photo2")
    private String image2;

    @Column(name = "p_photo3")
    private String image3;

    @Column(name = "p_photo4")
    private String image4;

    public ConsoleProduct(Integer productID, String name, String barcode, String category, String sub_Category,
            String unit, String hsn_Code, String gst, Integer cess, String current_Stock, String opening_Stock,
            String purchase_Rate, String retail_Rate, String mrp, String cost, String whole_Rate, String keyImage,
            String image1, String image2, String image3, String image4,String discription) {
        this.productID = productID;
        this.name = name;
        this.barcode = barcode;
        this.category = category;
        this.sub_Category = sub_Category;
        this.unit = unit;
        this.hsn_Code = hsn_Code;
        this.gst = gst;
        this.cess = cess;
        this.current_Stock = current_Stock;
        this.opening_Stock = opening_Stock;
        this.purchase_Rate = purchase_Rate;
        this.retail_Rate = retail_Rate;
        this.mrp = mrp;
        this.cost = cost;
        this.whole_Rate = whole_Rate;
        this.discription = discription;
        KeyImage = keyImage;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }
    public ConsoleProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
    public Integer getProductID() {
        return productID;
    }
    public void setProductID(Integer productID) {
        this.productID = productID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSub_Category() {
        return sub_Category;
    }
    public void setSub_Category(String sub_Category) {
        this.sub_Category = sub_Category;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getHsn_Code() {
        return hsn_Code;
    }
    public void setHsn_Code(String hsn_Code) {
        this.hsn_Code = hsn_Code;
    }
    public String getGst() {
        return gst;
    }
    public void setGst(String gst) {
        this.gst = gst;
    }
    public Integer getCess() {
        return cess;
    }
    public void setCess(Integer cess) {
        this.cess = cess;
    }
    public String getCurrent_Stock() {
        return current_Stock;
    }
    public void setCurrent_Stock(String current_Stock) {
        this.current_Stock = current_Stock;
    }
    public String getOpening_Stock() {
        return opening_Stock;
    }
    public void setOpening_Stock(String opening_Stock) {
        this.opening_Stock = opening_Stock;
    }
    public String getPurchase_Rate() {
        return purchase_Rate;
    }
    public void setPurchase_Rate(String purchase_Rate) {
        this.purchase_Rate = purchase_Rate;
    }
    public String getRetail_Rate() {
        return retail_Rate;
    }
    public void setRetail_Rate(String retail_Rate) {
        this.retail_Rate = retail_Rate;
    }
    public String getMrp() {
        return mrp;
    }
    public void setMrp(String mrp) {
        this.mrp = mrp;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getWhole_Rate() {
        return whole_Rate;
    }
    public void setWhole_Rate(String whole_Rate) {
        this.whole_Rate = whole_Rate;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getKeyImage() {
        return KeyImage;
    }
    public void setKeyImage(String keyImage) {
        KeyImage = keyImage;
    }
    public String getImage1() {
        return image1;
    }
    public void setImage1(String image1) {
        this.image1 = image1;
    }
    public String getImage2() {
        return image2;
    }
    public void setImage2(String image2) {
        this.image2 = image2;
    }
    public String getImage3() {
        return image3;
    }
    public void setImage3(String image3) {
        this.image3 = image3;
    }
    public String getImage4() {
        return image4;
    }
    public void setImage4(String image4) {
        this.image4 = image4;
    }

}
