package com.glearning.empcrud.controller;

import com.glearning.empcrud.model.Employee;
import com.glearning.empcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("employee", new Employee());
        return "register";
    }
    @PostMapping("/register")
   public String registerEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result){
       System.out.println(employee);
       System.out.println("Came inside the post method of register employee ....");
       if(result.hasErrors()){
           return "register";
       }
       this.employeeService.saveEmployee(employee);
       return "success";
   }
    @GetMapping("/employees")
    public String listAllEmployees(Model model){
        System.out.println("sIZE >>>>>>> ");
        System.out.println(this.employeeService.listAllEmployees().size());
        model.addAttribute("employees", this.employeeService.listAllEmployees());
        return  "list";

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
