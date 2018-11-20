package pl.rafalab.rafalworld.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rafalab.rafalworld.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByRole(String role);
}
