package toolee.tools.Repositories;

import org.springframework.data.repository.CrudRepository;
import toolee.tools.Models.Tool;

import java.util.Optional;

public interface ToolRepository extends CrudRepository<Tool, Long> {

    Optional<Tool> findById(Long id);

}
