package com.services;

import com.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee() ;
    Employee create(Employee employee);
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployeeById(int id);
}
