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
    @Query(value="INSERT INTO product (p_name, id, p_barcode,p_godown,p_category,p_unit,p_hsn,p_tax,cessp,p_curr_stock,p_opstock,p_pprice,p_srate1,mrp,cost,p_srate2) VALUES (:Pname,:productID, :barcode, :category,:sub_Category,:unit,:hsn_Code,:gst,:cess,:current_Stock,:opening_Stock,:purchase_Rate,:retail_Rate,:mrp,:cost,:whole_Rate)", nativeQuery = true)
    public void saveProduct(String Pname, Integer productID,String barcode,String category,String sub_Category,
        String unit,String hsn_Code,String gst,Integer cess,String current_Stock,String opening_Stock,String purchase_Rate
        ,String retail_Rate,String mrp,String cost,String whole_Rate);


    @Query(value="SELECT Max(id)+1 FROM product", nativeQuery = true)
    public String getPid();

    @Query(value="SELECT p_name from product WHERE p_name like :key% ", nativeQuery = true)
    public List<String> getPnames(String key);
}
