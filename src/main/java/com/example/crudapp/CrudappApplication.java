package com.example.crudapp;

import com.example.crudapp.DAO.EmployeeDAOInterface;
import com.example.crudapp.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(EmployeeDAOInterface employeeDAOInterface)
	{
		return runner->{
			queryEmployees(employeeDAOInterface);
		};
	}

	private void queryEmployees(EmployeeDAOInterface employeeDAOInterface) {

		List<Employee> employees = employeeDAOInterface.findAll();

		for(Employee emp: employees)
		{
			System.out.println(emp);
		}
	}

	private void readEmployee(EmployeeDAOInterface employeeDAOInterface) {

		int id =1;

		System.out.println("Reading employee with id: " + id);

		Employee emp = employeeDAOInterface.findById(id);

		System.out.println("Employee found, details are follows: ");

		System.out.println("First Name: " + emp.getFirstName());
		System.out.println("Last Name: " + emp.getLastName());
		System.out.println("Email: " + emp.getEmail());
	}

	private void createEmployee(EmployeeDAOInterface employeeDAOInterface) {

		//Creating employee object
		System.out.println("Creating Employee object..");
		Employee employee1 = new Employee("Bhuvan", "Savant", "123@gmail.com");
		Employee employee2 = new Employee("Vedu", "Savant", "vedu@gmail.com");
		Employee employee3 = new Employee("Atul", "Savant", "atul@gmail.com");
		Employee employee4 = new Employee("Deepa", "Savant", "deepa@gmail.com");

		//Saving the employee object
		employeeDAOInterface.save(employee1);
		employeeDAOInterface.save(employee2);
		employeeDAOInterface.save(employee3);
		employeeDAOInterface.save(employee4);

		//Show the id of the new employee
		System.out.println("Employee id : " + employee1.getId());
		System.out.println("Employee id : " + employee2.getId());
		System.out.println("Employee id : " + employee3.getId());
		System.out.println("Employee id : " + employee4.getId());

	}




}
