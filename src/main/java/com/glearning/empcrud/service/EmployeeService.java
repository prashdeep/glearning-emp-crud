package com.glearning.empcrud.service;

import com.glearning.empcrud.model.Employee;

import java.util.Optional;
import java.util.Set;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Optional<Employee> findById(long empId);

    Set<Employee> listAllEmployees();

    void deleteEmployee(long empId);

    Employee updateEmployee(long empId, Employee employee);
}
