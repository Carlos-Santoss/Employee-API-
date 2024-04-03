package in.bushansirgur.springrestapi.repository;

import in.bushansirgur.springrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

//para adicionar a interface importando o repositorio JPA, precisamos dizer o objeto/entidade e o tipo de dado
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
