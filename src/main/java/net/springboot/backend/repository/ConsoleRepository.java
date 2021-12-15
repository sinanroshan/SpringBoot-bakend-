package net.springboot.backend.repository;

import java.util.List;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.Product;

public interface ConsoleRepository extends JpaRepository<Product, Any>{

    //list All
    @Query(value="SELECT * FROM product", nativeQuery = true)
	public List<String[]>ShowAll();
    
}
