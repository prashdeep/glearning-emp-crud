package com.glearning.empcrud.client;

import com.glearning.empcrud.controller.EmployeeController;
import com.glearning.empcrud.model.Dependent;
import com.glearning.empcrud.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class EmployeeCRUDClient {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml");
        EmployeeController employeeController = applicationContext.getBean(EmployeeController.class);

        Employee employee = new Employee(12);
        employee.setName("Vishnu");
        employee.setAge(34);
        employee.setDateOfBirth(LocalDate.of(1985, 4,21));
        employee.setDepartment("HR");


        Dependent mother = new Dependent();
        mother.setAge(50);
        mother.setRelationship("mother");
        mother.setName("Veena");

        Dependent father = new Dependent();
        father.setAge(52);
        father.setRelationship("father");
        father.setName("Mohan");

        //very important
        mother.setEmployee(employee);
        father.setEmployee(employee);

        employee.getDependentSet().add(mother);
        employee.getDependentSet().add(father);

        employeeController.saveEmployee(employee);

       // employeeController.listAllEmployees().forEach(System.out::println);
    }
}
