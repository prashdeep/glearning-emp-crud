package com.glearning.empcrud.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//@Entity
//@Table(name = "projects")
public class Project {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    private String name;

    private LocalDate startDate;


    private Set<Employee> employeeSet;
}
