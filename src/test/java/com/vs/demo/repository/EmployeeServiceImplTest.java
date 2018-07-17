package com.vs.demo.repository;

import com.vs.demo.AssessmentApp;
import com.vs.demo.entity.Employee;
import com.vs.demo.service.EmployeeService;
import com.vs.demo.service.EmployeeServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssessmentApp.class)

public class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeDAO employeeDAO;

    @Test
    public void createTest(){
        Employee emp = getEmployee("testemp", 60000, 2);
        employeeService.create(emp);
        System.out.println(employeeService.getEmployee(1).toString());
        assertEquals("1", employeeService.getEmployee(1).getId().toString());
        assertEquals("60000", employeeService.getEmployee(1).getSalary().toString());
    }

    @Test
    public void updateTest(){
        Employee emp = getEmployee("testemp", 60000, 2);
        /*emp.setName("del123");
        emp.setSalary(60000);
        emp.setManager(2);*/
        employeeService.create(emp);
        System.out.println("before::" + employeeService.getEmployee(1).toString());

        emp.setName(emp.getName() + "xxx");

        employeeService.update(emp);
        System.out.println(employeeService.getEmployee(1).toString());
        assertEquals("testempxxx", employeeService.getEmployee(1).getName());
    }

    @Test
    public void deleteTest(){
        Employee emp = getEmployee("testemp", 60000, 2);
        employeeService.create(emp);
        System.out.println("before::" + employeeService.getEmployee(1).toString());

        employeeService.delete(1);
        //System.out.println(employeeService.getEmployee(1).toString());
        assertEquals(null, employeeService.getEmployee(1));
        employeeService.delete(100);
    }

    @Test
    public void printHeirarchyTest(){
        Employee emp1 = getEmployee("testemp2", 60000, 3);
        Employee emp2 = getEmployee("testemp3", 70000, 4);
        Employee emp3 = getEmployee("testemp4", 90000, null);
        employeeService.create(emp1);
        employeeService.create(emp2);
        employeeService.create(emp3);
        System.out.println("before::" + employeeService.getEmployee(1).toString());

        employeeService.printEmployeeHeirarchy(1);
        assertTrue(null!=employeeService.getEmployee(1));
        emp1.setManager(2);
        employeeService.update(emp1);
        assertEquals("2", emp1.getManager().toString());
        employeeService.printEmployeeHeirarchy(2);
    }

    private Employee getEmployee(String name, Integer sal, Integer man){
        Employee emp = new Employee();
        emp.setName(name);
        emp.setSalary(sal);
        emp.setManager(man);
        return emp;
    }
}
