package com.glearning.empcrud.service;

import com.glearning.empcrud.dao.EmployeeDAO;
import com.glearning.empcrud.model.Employee;
import com.glearning.empcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        Employee save = this.employeeRepository.save(employee);
        if(true){
           // throw new NullPointerException("");
        }
       return save;
    }

    @Override
    public Optional<Employee> findById(long empId) {
        return this.employeeRepository.findById(empId);
    }

    @Override
    public Set<Employee> listAllEmployees() {
        Set<Employee> employeeSet = new HashSet<>();
        this.employeeRepository.findAll().forEach(employee -> {
            employeeSet.add(employee);
        });
        return employeeSet;

    }

    @Override
    public void deleteEmployee(long empId) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(empId);
        employeeOptional.ifPresent(employee -> employeeRepository.delete(employee));
    }

    @Override
    public Employee updateEmployee(long empId, Employee employee) {
        return this.employeeRepository.save(employee);
    }
}