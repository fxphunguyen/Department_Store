package vn.fx.qh.sapo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Accessors(chain = true)
public class Employee {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", unique = true, length = 50, nullable = false)
    private String email;

    @Column(name = "phone", unique = true, length = 50, nullable = false)
    private String phone;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "birthday", length = 50, nullable = false)
    private String birthday;

    @Lob
    @Column(name = "gender", length = 50, nullable = false)
    private String gender;

    public Employee(Integer id) {
       this.id = id;
    }


}