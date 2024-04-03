package in.bushansirgur.springrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long id;

    //@JsonProperty("full_name") como o atributo será mostrado no Json de resposta
    @Column(name = "name" )
    private String name;
    //@JsonIgnore Será ignorado no payload de resposta
    @Column(name = "age" )
    private Long age;
    @Column(name = "location" )
    private String location;
    @Column(name = "email" )
    private String email;
    @Column(name = "department" )
    private String department;

}
