package com.vs.demo.repository;

import com.vs.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public void create(Employee emp);

    public void update(Employee emp);

    public Employee get(Integer id);

    public void delete(Integer id);

    public List<Employee> getManagers();
}
