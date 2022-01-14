package net.springboot.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.ConsoleLedger;

public interface ConsoleLedgerRepo extends JpaRepository<ConsoleLedger,Any> {

    @Modifying
	@Transactional
    @Query(value="TRUNCATE TABLE temp_pdt_flow", nativeQuery = true)
    public void resetTempTable();

    @Modifying
	@Transactional
	@Query(value = "INSERT INTO temp_pdt_flow (inv,date,qty,party,party_id,rate,form) \r\n"
			+ "VALUES( (SELECT id FROM product WHERE p_name = :pname),\r\n"
			+ "(SELECT p_pdate FROM product WHERE p_name = :pname),\r\n"
			+ "(SELECT p_curr_stock FROM product WHERE p_name = :pname), \r\n"
			+ "(SELECT supplierid FROM product WHERE p_name = :pname),\r\n"
			+ "(SELECT supplierid FROM product WHERE p_name = :pname),\r\n"
			+ "(SELECT cost FROM product WHERE p_name = :pname),'purchase')", nativeQuery = true)
	public void getPurchase(String pname);

    @Modifying
	@Transactional
    @Query(value="INSERT INTO temp_pdt_flow (inv,qty,party,party_id,date,rate,form) \r\n"
                    +"VALUES (:inv,:qty,:c_name,:c_id,:date,:tprice,'Sales')", nativeQuery = true)
    public void setTable(String inv, String qty, String tprice, String c_id, String date, String c_name);

    @Query(value="SELECT * from temp_pdt_flow", nativeQuery = true)
    public List<ConsoleLedger> getLedger();
    
}
