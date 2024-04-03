package in.bushansirgur.springrestapi.service;

import in.bushansirgur.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    Employee gerSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);

}
