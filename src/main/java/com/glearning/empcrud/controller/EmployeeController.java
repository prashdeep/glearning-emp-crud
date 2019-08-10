package com.glearning.empcrud.controller;

import com.glearning.empcrud.model.Employee;
import com.glearning.empcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public Employee saveEmployee(Employee employee){
        return employeeService.saveEmployee(employee);
    }

    public Set<Employee> listAllEmployees(){
        return  this.employeeService.listAllEmployees();
    }

    public Employee fetchEmployeeById(long empId){
        return null;
    }

    public Employee updateEmployee(long empId, Employee employee){
        return null;
    }

    public void deleteEmployee(long empId){

    }


}
