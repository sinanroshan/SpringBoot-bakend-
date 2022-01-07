package net.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.springboot.backend.model.ConsoleEmploye;


public interface EpmloyeeRepository extends JpaRepository<ConsoleEmploye,Integer> {

    @Query(value="SELECT * FROM emp WHERE emp_user_id = :username And emp_pass = :Password", nativeQuery = true)
	public String EmpLogin(String username, String Password);
    
    @Query(value="SELECT * FROM emp WHERE emp_user_id = :username And emp_pass = :Password", nativeQuery = true)
	public String getTokenKey(String username, String Password);
}
