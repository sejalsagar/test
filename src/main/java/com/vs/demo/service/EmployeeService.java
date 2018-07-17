package com.vs.demo.service;

import com.vs.demo.entity.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public void create(Employee emp);

    public void update(Employee emp);

    public void delete(Integer id);

    public Employee getEmployee(Integer id);

    public void printEmployeeHeirarchy(Integer id);
}
