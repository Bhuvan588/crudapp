package com.example.crudapp.DAO;

import com.example.crudapp.entity.Employee;
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAO implements EmployeeDAOInterface{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //As we are making changes in a database , we are performing a transaction
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee order by firstName", Employee.class);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee WHERE lastName=:data", Employee.class);

        query.setParameter("data", lastName); //the parameter

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Employee employee) {

        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int rowsDeleted = entityManager.createQuery("DELETE FROM Employee").executeUpdate();

        return rowsDeleted;

    }
}
