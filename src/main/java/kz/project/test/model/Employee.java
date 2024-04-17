package kz.project.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name ="email")
    private String email;
    @Column(name = "age")
    private String age;
    @Column(name = "addressId")
    private String addressId;
}
