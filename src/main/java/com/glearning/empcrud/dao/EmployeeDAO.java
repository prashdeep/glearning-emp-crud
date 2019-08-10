package com.glearning.empcrud.dao;

import com.glearning.empcrud.model.Employee;

import java.util.Optional;
import java.util.Set;

public interface EmployeeDAO {

    Employee saveEmployee(Employee emp);

    Set<Employee> listAllEmployees();

    Optional<Employee> findById(long id);

    void deleteEmployee(long id);

    Employee updateEmployee(long empId, Employee employee);
}
