package net.springboot.backend.repository;

import java.util.List;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.OrderData;

public interface OrderRepository extends JpaRepository<OrderData, Any>{
    
    @Query(value="SELECT * FROM orders", nativeQuery = true)
	public List<OrderData>getAll();
}
