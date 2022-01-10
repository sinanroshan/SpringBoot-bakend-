package net.springboot.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.ConsoleProduct;

public interface ConsoleRepository extends JpaRepository<ConsoleProduct, Any>{

    //list All
    @Query(value="SELECT * FROM product", nativeQuery = true)
	public List<ConsoleProduct>ShowAll();
    
    @Modifying
	@Transactional
    @Query(value="INSERT INTO product (p_name, id, p_barcode,p_godown,p_category,p_unit,p_hsn,p_tax,cessp,p_curr_stock,p_opstock,p_pprice,p_srate1,mrp,cost,p_srate2,p_photo,p_photo1,p_photo2,p_photo3,p_photo4,p_code,company,st,p_rack,rate1t1,rate2t1,mrpt1,plucode,scalerate,minstock,p_sec_unit,p_sec_p_rate,p_sec_s_rate1,p_sec_s_rate2,p_sec_no_unit,p_sec_opening,barc2,scale,USER,multi_rate,costt1,mrptt1,rate2tt2,rate1tt1,ind,prmonth,pr) VALUES (:Pname,:productID, :barcode, :category,:sub_Category,:unit,:hsn_Code,:gst,:cess,:current_Stock,:opening_Stock,:purchase_Rate,:retail_Rate,:mrp,:cost,:whole_Rate,:p_KeyImg,:image1,:image2,:image3,:image4,:PCode,'NIL','NOT TAX','NIL','0.0','0.0','0.0','0','0.0','0.0','NIL','0','0','0','1','0','0','0','Admin',0,'0','0',0,'0','1','MONTH','1')", nativeQuery = true)
    public void saveProduct(String Pname, Integer productID,String barcode,String category,String sub_Category,
        String unit,String hsn_Code,String gst,Integer cess,String current_Stock,String opening_Stock,String purchase_Rate
        ,String retail_Rate,String mrp,String cost,String whole_Rate, String p_KeyImg,
        String image1,String image2,String image3,String image4, String PCode);

    @Modifying
	@Transactional
    @Query(value="Update product SET p_name =:Pname, id =:productID, p_barcode =:barcode, p_godown =:category, p_category =:sub_Category ,p_unit =:unit,p_hsn =:hsn_Code,p_tax =:gst,cessp =:cess,p_curr_stock=:current_Stock,p_opstock=:opening_Stock,p_pprice=:purchase_Rate,p_srate1=:retail_Rate,mrp=:mrp,cost=:cost,p_srate2=:whole_Rate, p_photo=:p_KeyImg,p_photo1=:image1,p_photo2=:image2,p_photo2=:image2,p_photo3=:image3,p_photo4=:image4 WHERE p_name =:key", nativeQuery = true)
    public void UpdateProduct(String key, String Pname, Integer productID,String barcode,String category,String sub_Category,
        String unit,String hsn_Code,String gst,Integer cess,String current_Stock,String opening_Stock,String purchase_Rate
        ,String retail_Rate,String mrp,String cost,String whole_Rate,String p_KeyImg,
        String image1,String image2,String image3,String image4);

    @Query(value="SELECT Max(id)+1 FROM product", nativeQuery = true)
    public String getPid();

    @Query(value="SELECT p_name from product WHERE p_name like :key% ", nativeQuery = true)
    public List<String> getPnames(String key);

    @Query(value="SELECT * from invoice WHERE pname like :p_name ", nativeQuery = true)
    public List<String> getprodInv(String p_name);
}