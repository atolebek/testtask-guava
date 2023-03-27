package guava.test.guavapaytask.repository;

import guava.test.guavapaytask.models.RoleEnum;
import guava.test.guavapaytask.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleEnum name);
}
