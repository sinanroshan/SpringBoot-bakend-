package net.springboot.backend.repository;


import java.util.List;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import net.springboot.backend.model.Product;

@Repository
@Component
public interface ProductRepository extends CrudRepository<Product, Any>{
	
	//list All
	//@Query(value="SELECT * FROM product", nativeQuery = true)
	//public Iterable<Any> findAll();
	//by Category
	public List<Product>findByPcategory(String Category);
	//Search
	public List <Product> findByPnameContainingOrPcategoryContaining(String name, String brand);
	//serch keyword
	@Query(value="SELECT * FROM product WHERE product.p_name like :key% or product.p_category like :key%", nativeQuery = true)
	public List<Product>findByPnameContaining(String key);
	
	@Query(value = "SELECT * FROM product WHERE product.p_name =:pname" , nativeQuery = true)
	public List<Product>findByProductId(String pname);

	@Query(value = "SELECT * FROM product ORDER BY RAND() LIMIT 16" , nativeQuery = true)
	public List<Product>rnandom();

	@Query(value = "SELECT p_category FROM product WHERE product.p_name =:product" , nativeQuery = true)
	public String getPcategory(String product);

	@Query(value = "SELECT * FROM product where p_category=:category ORDER BY RAND() LIMIT 8" , nativeQuery = true)
	public List<Product> getSuggesionList(String category);
}
