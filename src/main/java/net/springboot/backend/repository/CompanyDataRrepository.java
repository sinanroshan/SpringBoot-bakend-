package net.springboot.backend.repository;

import java.util.List;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.CompanyData;

public interface CompanyDataRrepository extends JpaRepository<CompanyData, Any>{
    
    @Query(value="SELECT * FROM company", nativeQuery = true)
	public CompanyData getCompany();

    @Modifying
	@Transactional
    @Query(value="Update company SET cmp_add1=:address1,cmp_add2=:address2,cmp_phone=:phone,cmp_mail=:email,cmp_site=:website,cmp_gstno=:gstNo,cmp_city=:city,cmp_state=:state,cmp_country=:country,cmp_bname=:bank,cmp_bbranch=:bankBranch,cmp_bifsc=:bankIfce=:cmp_baccountno=:bankAccNO,cmp_logo=:Logo    WHERE cmp_name =:name", nativeQuery = true)
    public void updateData(String name,String address1,String address2,String phone,String email,String website,String gstNo,String city,String state,String country,String bank,String bankBranch,String bankIfce,String bankAccNO,String Logo);
}
