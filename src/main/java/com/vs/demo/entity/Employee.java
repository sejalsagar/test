package com.vs.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    private String name;
    private Integer salary;
    private Integer manager;


    public Employee(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    //@Column(name = "NAME", unique = false, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "SALARY", unique = false, nullable = false)
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    @Column(name = "MANAGER", unique = false, nullable = false)
    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    @Override
    public String toString(){
        return id + "," + name + "," + salary + "," + manager;
    }
}
