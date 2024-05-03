package in.bushansirgur.springrestapi.controller;
import in.bushansirgur.springrestapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import in.bushansirgur.springrestapi.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController // faz a função do @Controller e do @ResponseBody
public class Employeecontroller {
    //localhost:8080/api/v1/employees
    @Autowired
    private EmployeeService eService;



    //Precisamos chamar essa annotation para dizer o endpoint e o método
    //@RequestMapping(value="/employees", method = RequestMethod.GET)
    @GetMapping(value = "/employees") //te poupa de usar a annotation acima
    //@ResponseBody é pra mandar para o cliente a o corpo de resposta da requisição
    //@ResponseBody

    public ResponseEntity<List<Employee>> getEmployees (@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        //Aqui estamos chamando o objeto eService, da interface EmployeeService que está incrementada com o EmployeeServiceimpl
        return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    //pequeno exemplo da req: localhost:8080/employees/12
    @GetMapping(value = "/employees/{id}")
    // mesma coisa do metodo anterior, mas aqui será por id
    public  ResponseEntity<Employee> getEmployees (@PathVariable("id") Long id){
    //repare que a dente usa @PathVariable para tratar do ID a ser buscado
        return new ResponseEntity<Employee>(eService.gerSingleEmployee(id), HttpStatus.OK);
    }

    //pequeno exemplo da req: http://localhost:8080/employees?id=32
    @DeleteMapping(value = "/employees")
    public ResponseEntity<HttpStatus> deleteEmployee (@RequestParam("id") Long id) {
        /* repare que agora foi utilizada a annotation @RequestParam,
         * serve para utilizar de QueryParams*/
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
       return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees/filterByName")// vamos ver essa questao pra depois se tratando de um endpoit FEIO
    public ResponseEntity<List<Employee>> getEmployeesByName (@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")// vamos ver essa questao pra depois se tratando de um endpoit FEIO
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation (@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name,location), HttpStatus.OK);
    }
    @GetMapping("/employees/filterByKeyword")// vamos ver essa questao pra depois se tratando de um endpoit FEIO
    public ResponseEntity<List<Employee>> getEmployeesByKeyword (@RequestParam String keyword) {
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(keyword), HttpStatus.OK);
    }
}