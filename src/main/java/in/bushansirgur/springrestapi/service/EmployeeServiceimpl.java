package in.bushansirgur.springrestapi.service;
import in.bushansirgur.springrestapi.model.Employee;

import in.bushansirgur.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    private static  List<Employee> list = new ArrayList<>();


    //esse método adiciona itens na lista como se fosse um "Mocking service"
   /* static {
        Employee e = new Employee();
        e.setName("Carlos");
        e.setAge(21L);
        e.setDepartment("Tech");
        e.setEmail("cedudu03@gmail.com");
        e.setLocation("Brasilia");
        list.add(e);

        e.setName("Angelo");
        e.setAge(23L);
        e.setDepartment("Tech");
        e.setEmail("angelo.araujo@gmail.com");
        e.setLocation("Brasilia");
        list.add(e);

    }*/
    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize);
        return eRepository.findAll(pages).getContent();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee gerSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id " + id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);
    }
    public List<Employee> getEmployeesByNameAndLocation(String name,String location) {
        return eRepository.findByNameAndLocation(name,location);
    }

    @Override
    public List<Employee>getEmployeesByKeyword(String name) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return eRepository.findByNameContaining(name, sort);
    }

}
