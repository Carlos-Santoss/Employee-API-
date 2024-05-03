package in.bushansirgur.springrestapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
    /*
    * Foi visto que nao é necessario
    * adicionar a annotation @Column
    * quando se está utilizando JPA
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id" )
    private Long id;
    //@JsonProperty("full_name") como o atributo será mostrado no Json de resposta
    //@Column(name = "name" )
    @NotBlank( message = "Nome nao pode ser nulo")
    private String name;
    //@JsonIgnore Será ignorado no payload de resposta
    //@Column(name = "age" )
    private Long age = 0L;
    //@Column(name = "location" )
    private String location;
    //@Column(name = "email" )
    @Email(message="Por favor, insira um email valido") //Essa annotation verifica se o email enviado pelo body é valido
    private String email;
    //@Column(name = "department" )
    @NotBlank(message = "Departamento nao pode ser nulo")
    private String department;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)// esse aqui vamos manter pois queremos o valor diferente no bd e no atributo
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")// esse aqui vamos manter pois queremos o valor diferente no bd e no atributo
    private Date updatedAt;
}