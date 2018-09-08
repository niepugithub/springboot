package com.example.controller;


import com.example.domain.Employee;
import com.example.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployee(){
        return employeeMapper.getAllEmployee();
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmploeeById(@PathVariable("empId") int id){
        return employeeMapper.getEmployeeById(id);
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    @ResponseBody
    public void addEmployee(@RequestBody Employee employee){
        employeeMapper.addEmployee(employee);
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    @ResponseBody
    public int updateEmployee(@RequestBody Employee employee){
        return employeeMapper.updateEmployee(employee);
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteEmployee(@PathVariable("empId") int id){
        return employeeMapper.deleteEmployee(id);
    }
}
