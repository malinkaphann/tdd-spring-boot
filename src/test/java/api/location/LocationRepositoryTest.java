package api.location;

import java.util.List;

import api.location.domain.Country;
import api.location.repository.LocationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getCountries_shouldReturnCountries() {
        entityManager.persistFlushFind(new Country("Cambodia"));
        List<Country> countries = locationRepository.findAll();
        assertTrue(countries.size() == 1 && countries.get(0).getName().equals("Cambodia"));
    }
}
