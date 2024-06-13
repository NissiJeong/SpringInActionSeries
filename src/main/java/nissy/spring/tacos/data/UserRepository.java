package nissy.spring.tacos.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nissy.spring.tacos.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
