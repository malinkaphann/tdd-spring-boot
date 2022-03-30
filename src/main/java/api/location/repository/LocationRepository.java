package api.location.repository;

import api.location.domain.Country;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface LocationRepository extends CrudRepository<Country, Integer> {

    public List<Country> findAll();
}
