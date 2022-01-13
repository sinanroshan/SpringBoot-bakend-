package net.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import net.springboot.backend.model.PCategory;


@Repository
@Component
public interface PCategoryRepository extends CrudRepository<PCategory, Long>{
	
	public List<PCategory>findBySuperCategory(String Category);

	@Query(value="SELECT * FROM p_category Order By name ", nativeQuery = true)
	public List<PCategory> AllCategoris();
	
}
