package api.location;
/*
 * User: ohahlev@gmail.com
 * Project: api
 * Date: 8/9/20
 * Here is some description
 */

import api.location.domain.Country;
import api.location.repository.LocationRepository;
import api.location.service.LocationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    private LocationService locationService;

    @Before
    public void setUp() {
       this.locationService = new LocationService(locationRepository);
    }

    @Test
    public void getCountries_shouldReturnCountries() {
        given(locationRepository.findAll()).willReturn(new ArrayList<Country>());
        List<Country> countries = locationService.getCountries();
        assertTrue(countries.size() == 0);
    }

}
