package com.glearning.empcrud.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    private String name;

    private LocalDate startDate;


    @ManyToMany()
    @JoinTable(name = "employee_projects",
               joinColumns = @JoinColumn(name="project_id", referencedColumnName = "projectId"),
               inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "emp_id")
    )
    private Set<Employee> employeeSet = new HashSet<>();

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectId == project.projectId &&
                Objects.equals(name, project.name) &&
                Objects.equals(startDate, project.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, name, startDate);
    }
}
