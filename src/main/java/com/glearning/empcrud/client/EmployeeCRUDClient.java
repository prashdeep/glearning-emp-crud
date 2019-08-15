package com.glearning.empcrud.client;

import com.glearning.empcrud.config.AppConfig;
import com.glearning.empcrud.controller.EmployeeController;
import com.glearning.empcrud.model.Address;
import com.glearning.empcrud.model.Dependent;
import com.glearning.empcrud.model.Employee;
import com.glearning.empcrud.model.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class EmployeeCRUDClient {

    public static void main(String[] args) {
        //ApplicationContext applicationContext =
          //      new ClassPathXmlApplicationContext("application-context.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeController employeeController = applicationContext.getBean(EmployeeController.class);

        Employee employee = new Employee("Vishnu");
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

        Address address = new Address();
        address.setState("Karnataka");
        address.setCity("Bangalore");
        address.setZipCode("577142");

        employee.setAddress(address);
        employee.addDependent(mother);
        employee.addDependent(father);

        Project javaProject = new Project();
        javaProject.setName("Java Project");
        javaProject.setStartDate(LocalDate.now());

        Project dotnetProject = new Project();
        dotnetProject.setName("Dotnet Project");
        dotnetProject.setStartDate(LocalDate.now());

        Employee ramesh = new Employee("ramesh");
        Employee linda = new Employee("linda");
        Employee ravi = new Employee("ravi");

        employee.addFollower(ramesh);
        employee.addFollower(linda);
        employee.addFollower(ravi);

        employee.addProject(javaProject);
        employee.addProject(dotnetProject);

        employeeController.saveEmployee(employee);


       /* Set<Employee> employees = employeeController.listAllEmployees();
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee1 = iterator.next();
            if(employee1.getName().equalsIgnoreCase("linda")){
                System.out.println(employee1.getFollowers());
            }
        }*/

        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }
}
