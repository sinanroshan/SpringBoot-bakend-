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
		private String KeyImage;
	
		@Column(name = "p_photo1")
		private String image1;
	
		@Column(name = "p_photo2")
		private String image2;
	
		@Column(name = "p_photo3")
		private String image3;
	
		@Column(name = "p_photo4")
		private String image4;
		
		@Column(name = "p_category")
		private String pcategory;

		public Product(String productId, String price, String pname, String mrp, String supplierId, String keyImage,
				String image1, String image2, String image3, String image4, String pcategory) {
			this.productId = productId;
			Price = price;
			this.pname = pname;
			Mrp = mrp;
			SupplierId = supplierId;
			KeyImage = keyImage;
			this.image1 = image1;
			this.image2 = image2;
			this.image3 = image3;
			this.image4 = image4;
			this.pcategory = pcategory;
		}
		public Product() {
			super();
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

		public String getPcategory() {
			return pcategory;
		}

		public void setPcategory(String pcategory) {
			this.pcategory = pcategory;
		}
			
}
