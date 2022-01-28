package net.springboot.backend.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.AddsModel;

public interface AddAndOfferRepository extends JpaRepository<AddsModel, String> {

    @Modifying
	@Transactional
    @Query(value="TRUNCATE TABLE addandoffers", nativeQuery = true)
    public void claerTable();


    @Modifying
	@Transactional
    @Query(value="INSERT INTO addandoffers (add1,add2,add3,add4,add5) \r\n"
			+ "VALUES(:a1,:a2,:a3,:a4,:a5)", nativeQuery = true)
    public void saveAdd(String a1,String a2,String a3,String a4,String a5);

    @Query(value="SELECT * FROM addandoffers", nativeQuery = true)
public AddsModel getAdds();
}
