package com.glearning.empcrud.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dependents")
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long depId;

    private String Name;

    private String relationship;

    private int age;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public long getDepId() {
        return depId;
    }

    public void setDepId(long depId) {
        this.depId = depId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependent dependent = (Dependent) o;
        return depId == dependent.depId &&
                Objects.equals(relationship, dependent.relationship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depId, relationship);
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "depId=" + depId +
                ", Name='" + Name + '\'' +
                ", relationship='" + relationship + '\'' +
                ", age=" + age +
                ", employee=" + employee +
                '}';
    }
}
