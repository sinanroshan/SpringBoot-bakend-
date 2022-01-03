package net.springboot.backend.repository;

import java.util.List;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.CompanyData;

public interface CompanyDataRrepository extends JpaRepository<CompanyData, Any>{
    
    @Query(value="SELECT * FROM company", nativeQuery = true)
	public CompanyData getCompany();
}
