package com.vs.demo.service;

import com.vs.demo.entity.Employee;
import com.vs.demo.repository.EmployeeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAOImpl employeeDAO;

    public void create(Employee emp){
        employeeDAO.create(emp);
    }

    public void update(Employee emp){
        /*Employee emp = employeeDAO.get(id);
        emp.setName("SagarT");
        emp.setManager(3);*/
        employeeDAO.update(emp);
    }

    public void delete(Integer id){
        employeeDAO.delete(id);
    }

    public Employee getEmployee(Integer id){
        return employeeDAO.get(id);
    }

    public void printEmployeeHeirarchy(Integer id){
        List<Employee> managerList = employeeDAO.getManagers();
        Map<Integer,Employee> managers = new HashMap<>();
        managerList.forEach((emp) -> {
            managers.put(emp.getId(), emp);
        });
        Employee employee = employeeDAO.get(id);
        System.out.print(employee.getName());
        print(managers,employee);
        System.out.println("\n");
    }

    private void print(Map<Integer,Employee> managers, Employee emp){
        Integer manager = emp.getManager();
        if(null!= manager){
            System.out.print("->" + managers.get(manager).getName());
            if(emp.getId()==manager){
                System.out.println("\nEmloyee is manager to himself... oops not possible hmmm!!!");
                return;
            }
            print(managers, managers.get(manager));
        }
        return;
    }

}
