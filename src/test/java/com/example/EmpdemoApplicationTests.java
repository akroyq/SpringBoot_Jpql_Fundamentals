package com.example;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@SpringBootTest
class EmpdemoApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void saveEmployee() {
		Employee emp = new Employee();
		emp.setName("amit");
		emp.setEmail("akroyq@gmail.com");
		emp.setMobile("1234567890");
		emp.setSalary(10000);
		employeeRepository.save(emp);
	}

	@Test
	void deleteEmployeeById() {
		employeeRepository.deleteById(1L);
	}

	@Test
	void findEmployeeById() {
		Optional<Employee> byId = employeeRepository.findById(3L);
		if (byId.isPresent()) {
			Employee employee = byId.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		} else {
			System.out.println("Record not found");
		}
	}

	@Test
	void getAllEmployees() {
		Iterable<Employee> empItr = employeeRepository.findAll();
		for (Employee employee : empItr) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		}
	}

	@Test
	void findEmployeeByEmail() {
		Optional<Employee> byEmail = employeeRepository.findByEmail("akroyq@gmail.com");
		if (byEmail.isPresent()) {
			Employee employee = byEmail.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		} else {
			System.out.println("Record not found");
		}
	}

	@Test
	void findEmployeeByMobile() {
		Optional<Employee> byMobile = employeeRepository.findByMobile("1234567890");
		if (byMobile.isPresent()) {
			Employee employee = byMobile.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		} else {
			System.out.println("Record not found");
		}
	}

	@Test
	void findEmployeeByEmailAndMobile() {
		Optional<Employee> byEmailAndMobile = employeeRepository.findByEmailAndMobile("akroyq@gmail.com",
				"12345678901");
		if (byEmailAndMobile.isPresent()) {
			Employee employee = byEmailAndMobile.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		} else {
			System.out.println("Record not found");
		}
	}

	@Test
	void findEmployeeByEmailOrMobile() {
		List<Employee> byEmailOrMobile = employeeRepository.findByEmailOrMobile("suman@gmail.com", "1234567890");
		for (Employee employee : byEmailOrMobile) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		}

	}

	@Test
	void existsEmployeeByEmail() {
		boolean val = employeeRepository.existsByEmail("suman@gmail.com");
		System.out.println(val);

	}

	@Test
	void existsEmployeeByMobile() {
		boolean val = employeeRepository.existsByMobile("1234567890");
		System.out.println(val);

	}

	@Test
	void updateEmployee() {
		Employee emp = new Employee();
		emp.setId(4);
		emp.setName("suman");
		emp.setEmail("suman@gmail.com");
		emp.setMobile("0987654321");
		emp.setSalary(90000);
		employeeRepository.save(emp);
	}

	@Test
	void findQueryByEmailEmployee() {
		Employee emp = employeeRepository.findEmployeeByEmail("suman@gmail.com");
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getEmail());
	}

	@Test
	void findQueryByMobileEmployee() {
		Employee emp = employeeRepository.findEmployeeByMobile("1234567890");
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getEmail());
	}

	@Test
	void findQueryByEmailAndMobileEmployee() {
		Employee emp = employeeRepository.findEmployeeByEmailAndMobile("akroyq@gmail.com", "1234567890");
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getEmail());
	}

}
