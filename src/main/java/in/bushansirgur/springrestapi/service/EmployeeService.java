package in.bushansirgur.springrestapi.service;

import in.bushansirgur.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber, int pageSize);
    Employee saveEmployee(Employee employee);
    Employee gerSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByKeyword(String keyword);
}