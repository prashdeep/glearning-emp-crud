package com.glearning.empcrud.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee implements Serializable, Comparable<Employee>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private long empId;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(name = "dept_name")
    private String department;

    @Column(name = "emp_age")
    private int age;

    @Column(name = "emp_dob")
   // @Transient
    private LocalDate dateOfBirth;

    @ElementCollection
    @CollectionTable(name="phone_numbers", joinColumns = @JoinColumn(name = "emp_id"))
    private List<String> phoneNumbers;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_relationship",
               joinColumns = @JoinColumn(name = "followed_id"),
               inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private Set<Employee> followers = new HashSet<>();

    @ManyToMany(mappedBy = "followers", fetch = FetchType.EAGER)
    private Set<Employee> following = new HashSet<>();



    @OneToMany( mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Dependent> dependentSet = new HashSet<>();

    @ManyToMany(mappedBy = "employeeSet", cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Address address;

    public Set<Employee> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Employee> followers) {
        this.followers = followers;
    }

    public Set<Employee> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Employee> following) {
        this.following = following;
    }

    public void addFollower(Employee employee) {
        followers.add(employee);
        employee.following.add(this);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        address.setEmployee(this);
    }

    public Set<Dependent> getDependentSet() {
        return dependentSet;
    }

    public void setDependentSet(Set<Dependent> dependentSet) {
        this.dependentSet = dependentSet;
    }

    public long getEmpId() {
        return empId;
    }

    public Employee(){}

    public Employee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void addDependent(Dependent dependent){
        this.getDependentSet().add(dependent);
        dependent.setEmployee(this);
    }

    public void addProject(Project project){
        this.getProjects().add(project);
        project.getEmployeeSet().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name);
    }

    @Override
    public int compareTo(Employee employee) {
        return (int)(this.empId - employee.empId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
