package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
// CURD Operation on Employee Object
	
 //Find a record based on Column Names. We use finder methods in spring boot
	Optional<Employee> findByEmail(String email);
	Optional<Employee> findByMobile(String mobile);
	Optional<Employee> findByEmailAndMobile(String email, String mobile);
	List<Employee> findByEmailOrMobile(String email, String mobile);
	
	//if we want to check record exist or not we use existByColumnName
	boolean existsByEmail(String email);
	boolean existsByMobile(String mobile);
	
	//JPQL
	@Query("select emp from Employee emp where emp.email=:em") 
	Employee findEmployeeByEmail(@Param("em")String emailId); 
	
	@Query("select e from Employee e where e.mobile=:m")
	Employee findEmployeeByMobile(@Param("m")String mobile);
	
	@Query("select e from Employee e where e.email=:em and e.mobile=:m")
	Employee findEmployeeByEmailAndMobile(@Param("em") String email, @Param("m") String mobile);
	
	@Query("select e from Employee e where e.email=:em or e.mobile=:m")
	List<Employee> findEmployeeByEmailOrMobile(@Param("em") String email, @Param("m") String mobile);
}
