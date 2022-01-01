package net.springboot.backend.repository;

import java.util.List;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.InvoiceData;

public interface InvoiceDataRepository extends JpaRepository<InvoiceData, Any> {
    
    @Query(value="SELECT * FROM invoice WHERE invno = :invNo", nativeQuery = true)
	public List<InvoiceData> findByinv(String invNo);
}
