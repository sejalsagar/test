package com.vs.demo;

import com.vs.demo.entity.Employee;
import com.vs.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AssessmentApp implements CommandLineRunner{
    /*@Autowired
    SoccerService soccerService;*/

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    public static void main(String[] args) {
        SpringApplication.run(AssessmentApp.class, args);
    }
    @Override
    public void run(String... arg0) throws Exception {

        Employee emp = new Employee();
        //emp.setId(1);
        emp.setName("del");
        emp.setSalary(60000);
        emp.setManager(2);
        //employeeServiceImpl.update(2);
        //employeeServiceImpl.create(emp);
        //employeeServiceImpl.printEmployeeHeirarchy(1);
        //employeeServiceImpl.delete(4);

        System.out.println("Test" + employeeServiceImpl.getEmployee(1));
    }
}