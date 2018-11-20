package pl.rafalab.rafalworld.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long id;

    @Column(name = "role")
    @NotNull
    private String role;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }



}