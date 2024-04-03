package in.bushansirgur.springrestapi.controller;
import in.bushansirgur.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import in.bushansirgur.springrestapi.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController // faz a função do @Controller e do @ResponseBody
public class Employeecontroller {
    //localhost:8080/api/v1/employees
    @Autowired
    private EmployeeService eService;

/*@Value("${app.name}")
*private String appName;
*
*
*  @Value("${app.version}")
*   private String appVersion;
*
* @GetMapping(value = "/version")
*public String getAppDetails (){
*
*   return appName +" - " +appVersion ;
*}
*/

    //Precisamos chamar essa annotation para dizer o endpoint e o método
    //@RequestMapping(value="/employees", method = RequestMethod.GET)
    @GetMapping(value = "/employees") //te poupa de usar a annotation acima
    //@ResponseBody é pra mandar para o cliente a o corpo de resposta da requisição
    //@ResponseBody
    public List<Employee> getEmployees (){
        //Aqui estamos chamando o objeto eService, da interface EmployeeService que está incrementada com o EmployeeServiceimpl
        return eService.getEmployees() ;
    }

    //pequeno exemplo da req: localhost:8080/employees/12
    @GetMapping(value = "/employees/{id}")
    // mesma coisa do metodo anterior, mas aqui será por id
    public  Employee getEmployees (@PathVariable("id") Long id){
    //repare que a dente usa @PathVariable para tratar do ID a ser buscado
        return eService.gerSingleEmployee(id);
    }

    //pequeno exemplo da req: http://localhost:8080/employees?id=32
    @DeleteMapping(value = "/employees")
    public void deleteEmployee (@RequestParam("id") Long id) {
        /* repare que agora foi utilizada a annotation @RequestParam,
         * serve para utilizar de QueryParams*/
        eService.deleteEmployee(id);
    }

    @PutMapping ("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return eService.updateEmployee(employee);
    }

    @PostMapping(value = "/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
       return eService.saveEmployee(employee);
    }

}
 