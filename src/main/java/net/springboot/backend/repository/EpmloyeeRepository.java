package net.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.ConsoleEmploye;


public interface EpmloyeeRepository extends JpaRepository<ConsoleEmploye,Integer> {

    @Query(value="SELECT phone FROM customer WHERE (customer.phone = :username Or customer.email_id = :username) And customer.password1 = :Password", nativeQuery = true)
	public String EmpLogin(String username, String Password);
    
    @Query(value="SELECT phone , email_id FROM customer WHERE (customer.phone = :username Or customer.email_id = :username) And customer.password1 = :Password", nativeQuery = true)
	public String getTokenKey(String username, String Password);
}
