package com.glearning.empcrud.dao;

import com.glearning.empcrud.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDAODBImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee saveEmployee(Employee emp) {
        Session currentSession = this.sessionFactory.getCurrentSession();
        currentSession.save(emp);
        return emp;
    }

    @Override
    public Set<Employee> listAllEmployees() {
        Session currentSession = this.sessionFactory.getCurrentSession();
        List employees = currentSession.createQuery("From Employee").list();
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.addAll(employees);
        return employeeSet;
    }

    @Override
    public Optional<Employee> findById(long id) {
        Session currentSession = this.sessionFactory.getCurrentSession();
        Employee employee = currentSession.find(Employee.class, id);
        return Optional.ofNullable(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        Session currentSession = this.sessionFactory.getCurrentSession();
        Employee employee = currentSession.find(Employee.class, id);
        if(Objects.nonNull(employee)) {
            currentSession.delete(employee);
        }
    }

    @Override
    public Employee updateEmployee(long empId, Employee employee) {
        Session currentSession = this.sessionFactory.getCurrentSession();
        Employee empFromDB = currentSession.find(Employee.class, empId);

        if(Objects.nonNull(empFromDB)) {
            empFromDB.setName(employee.getName());
            empFromDB.setDepartment(employee.getDepartment());
            empFromDB.setDateOfBirth(employee.getDateOfBirth());
            empFromDB.setAge(employee.getAge());
            currentSession.save(employee);
        }
        return empFromDB;
    }
}
