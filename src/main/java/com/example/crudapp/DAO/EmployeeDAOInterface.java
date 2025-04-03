package com.example.crudapp.DAO;

import com.example.crudapp.entity.Employee;

public interface EmployeeDAOInterface {

    void save(Employee employee);

    Employee findById(Integer id);
}
