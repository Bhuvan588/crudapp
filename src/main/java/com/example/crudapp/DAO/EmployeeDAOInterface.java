package com.example.crudapp.DAO;

import com.example.crudapp.entity.Employee;

import java.util.List;

public interface EmployeeDAOInterface {

    void save(Employee employee);

    Employee findById(Integer id);

    List<Employee> findAll();

    List<Employee> findByLastName(String lastName);


    void update(Employee employee);

    void delete(int id);

    int deleteAll();
}
