package toolee.tools.Repositories;

import org.springframework.data.repository.CrudRepository;
import toolee.tools.Models.AppUser;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<AppUser, Long> {
    Optional <AppUser> findById(Long id);
    AppUser findByUsername(String username);
    List <AppUser> findByCity(String city);
}