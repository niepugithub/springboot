package com.example.controller;

import com.example.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestEmployeeController {

    @Autowired
    private EmployeeController employeeController;

    @Test
    public void testGetAllEmployee(){
        System.out.println(employeeController.getAllEmployee());
    }

    @Test
    public void testEmployeeById(){
        System.out.println(employeeController.getEmploeeById(2));
    }

    @Test
    public void testAddEmployee(){
        Employee employee = new Employee(1,"3","张3","架构师");
        employeeController.addEmployee(employee);
        System.out.println(employee);
    }
    @Test
    public void testUpdateEmployee(){
        Employee employee = new Employee(2,"3","里里3","架构师");
        int i = employeeController.updateEmployee(employee);
        System.out.println(i+"=====================");
    }

    @Test
    public void testDeleteEmployee(){
        int i = employeeController.deleteEmployee(7);
        System.out.println(i+"=====================");
    }
}


