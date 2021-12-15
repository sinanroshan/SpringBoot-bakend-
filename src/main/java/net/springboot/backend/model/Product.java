package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="p_barcode")
	private String productId;
	
		@Column(name = "p_srate1")
	    private String Price;		

		@Column(name = "p_name")
	    private String pname;
		
		@Column(name = "mrp")
	    private String Mrp;
		
		@Column(name = "Supplierid")
	    private String SupplierId;
		
		@Column(name = "p_photo")
	    private String Image1;
		
		@Column(name = "p_category")
		private String pcategory;
		

		public Product(String phone, String productId, String price, String pname, String mrp, String supplierId, String image1, String category) {
			super();
			this.productId = productId;
			Price = price;
			this.pname = pname;
			Mrp = mrp;
			SupplierId = supplierId;
			Image1 = image1;
			pcategory = category;
		}
public Product() {
		// TODO Auto-generated constructor stub
	}

public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getPrice() {
	return Price;
}
public void setPrice(String price) {
	Price = price;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getMrp() {
	return Mrp;
}
public void setMrp(String mrp) {
	Mrp = mrp;
}
public String getSupplierId() {
	return SupplierId;
}
public void setSupplierId(String supplierId) {
	SupplierId = supplierId;
}
public String getImage1() {
	return Image1;
}
public void setImage1(String image1) {
	Image1 = image1;
}
public String getPcategory() {
	return pcategory;
}
public void setPcategory(String pcategory) {
	this.pcategory = pcategory;
}

			
}
