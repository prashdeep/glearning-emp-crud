package com.glearning.empcrud.service;

import com.glearning.empcrud.dao.EmployeeDAO;
import com.glearning.empcrud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    public Optional<Employee> findById(long empId) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Set<Employee> listAllEmployees() {
        return this.employeeDAO.listAllEmployees();
    }

    @Override
    @Transactional
    public void deleteEmployee(long empId) {
        this.employeeDAO.deleteEmployee(empId);
    }

    @Override
    @Transactional
    public Employee updateEmployee(long empId, Employee employee) {
        return this.employeeDAO.updateEmployee(empId, employee);
    }
}
