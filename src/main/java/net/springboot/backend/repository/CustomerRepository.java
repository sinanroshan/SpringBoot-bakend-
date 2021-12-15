package net.springboot.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	@Query(value="SELECT * FROM customer WHERE customer.phone = :uname", nativeQuery = true)
	public List<Customer> findByPhoneNo(String uname);
	
	@Query(value="SELECT phone, f_name, s_name,email_id FROM customer WHERE customer.phone = :uname", nativeQuery = true)
	public String getcustomer(String uname);

	@Query(value="SELECT phone FROM customer WHERE (customer.phone = :username Or customer.email_id = :username) And customer.password1 = :Password", nativeQuery = true)
	public String login(String username, String Password);
	
	@Query(value="SELECT phone , email_id FROM customer WHERE (customer.phone = :username Or customer.email_id = :username) And customer.password1 = :Password", nativeQuery = true)
	public String getTokenKey(String username, String Password);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE customer SET customer.tokenKey = :token WHERE (customer.phone = :username Or customer.email_id = :username) And customer.password1 = :Password ", nativeQuery = true)
	public void setSecureToken(String token, String username, String Password);

	@Modifying
	@Transactional
	@Query(value ="INSERT INTO customer (phone, f_name, s_name,email_id,password1)VALUES (:phone_no,:fname, :sname,:mail_id,:pass1)", nativeQuery = true)
	public void DoRegister(String fname,String sname,String phone_no,String mail_id,String pass1);
	
	@Query(value="SELECT f_name FROM customer WHERE (customer.phone = :phone) And customer.tokenKey = :token", nativeQuery = true)
	public String getName(String phone,String token);

	@Modifying
	@Transactional
	@Query(value ="Update customer SET fullName = :fname, mobNo =:phone_no, area =:Area, houseNo = :House_n, pincode =:Pincode, landmark =:Landmark, town_city =:Town_city WHERE customer.phone = :uname ", nativeQuery = true)
	public void SetAddress(String uname,String fname,String phone_no,String Area,String House_n,String Pincode,String Landmark,String Town_city);

	@Query(value="SELECT fullName, mobNo, area ,houseNo, pincode, landmark, town_city FROM customer WHERE phone = :phone_no", nativeQuery = true)
	public String getAdd(String phone_no);
	
	@Modifying
	@Transactional
	@Query(value= "INSERT INTO order_inv (c_id, total_amount,prod_qty, order_date,order_status) VALUES (:phone,:total_price,:qty,:date,:status)", nativeQuery = true)
	public void saveOrder(String phone, Integer qty, String total_price,String date, String status);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE order_inv SET \r\n"
			+ "c_fullname =( SELECT fullName FROM customer WHERE phone = :phone ),\r\n"
			+ "c_phone=( SELECT mobNo FROM customer WHERE phone = :phone),\r\n"
			+ "c_place=( SELECT AREA FROM customer WHERE phone = :phone), \r\n"
			+ "c_home_no =( SELECT houseNo FROM customer WHERE phone = :phone),\r\n"
			+ "c_pin=( SELECT pincode FROM customer WHERE phone = :phone),\r\n"
			+ "c_city=( SELECT town_city FROM customer WHERE phone = :phone),\r\n"
			+ "c_landmark=( SELECT landmark FROM customer WHERE phone = :phone)\r\n"
			+ "WHERE inv_no =:inv_no", nativeQuery = true)
	public void saveOrderAdress(String phone, String inv_no );
	
	@Query(value = "select inv_no from order_inv", nativeQuery = true)
	public String[] getInv();
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO inv_bill (invno,pid, pname,pqty,pcategory,price,mrp,tprice,order_status) VALUES (:inv,:p_id,:p_name,:p_qty,:pcategory,:price,:mrp,:tprice,:status)", nativeQuery = true)
	public void saveBill(String inv,String p_id, String p_name, String p_qty,String pcategory,String price,String mrp,String tprice,String status);

	@Query(value = "SELECT inv_no,total_amount,prod_qty, order_date, order_status from order_inv WHERE c_id=:key ORDER BY inv_no DESC",nativeQuery = true)
	public String[][] getOrder(String key);
	
	@Query(value = "SELECT * from inv_bill WHERE invno=:key",nativeQuery = true)
	public List<String[]> getProdList(String key);
	
	@Query(value = "SELECT * from order_inv WHERE inv_no=:key",nativeQuery = true)
	public List<String[]> getBill(String key);

	@Modifying
	@Transactional
	@Query(value = "UPDATE inv_bill SET \r\n"
			+ "order_status =:status \r\n"
			+ "WHERE invno =:inv_no And pid=:item" , nativeQuery = true)
	public void OrderItemStatus(String inv_no,String item, String status );

	@Query(value = "SELECT order_status from inv_bill WHERE invno=:inv",nativeQuery = true)
	public List<String> chekorderStatus(String inv);

	@Modifying
	@Transactional
	@Query(value = "UPDATE order_inv SET \r\n"
			+ "order_status =:status \r\n"
			+ "WHERE inv_no =:invno" , nativeQuery = true)
	public void OrderStatus(String invno, String status );
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE inv_bill SET \r\n"
			+ "order_status =:status \r\n"
			+ "WHERE invno =:inv_no" , nativeQuery = true)
	public void setOrderItemStatus(String inv_no, String status );
}

