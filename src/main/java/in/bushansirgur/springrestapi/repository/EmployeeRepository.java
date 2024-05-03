package in.bushansirgur.springrestapi.repository;

import in.bushansirgur.springrestapi.model.Employee;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.awt.print.Pageable;
import java.util.List;

//para adicionar a interface importando o repositorio JPA, precisamos dizer o objeto/entidade e o tipo de dado
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    //SELECT * FROM table WHERE name="Carlos" AND location="Norte"
    List<Employee> findByNameAndLocation(String name, String location);
    List<Employee> findByNameContaining(String keyword, Sort Sort);
}
