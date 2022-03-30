package api.location;

import java.util.List;
import api.location.controller.LocationController;
import api.location.domain.Country;
import api.location.service.DummyService;
import api.location.service.LocationService;
import org.junit.Test;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationController.class)
public class LocationControllerTest {

    @Autowired
    private MockMvc mockedMvc;

    @MockBean
    LocationService locationService;

    @MockBean
    DummyService dummyService;

    @Test
    public void getCountries_shouldReturnEmptyList() throws Exception {

        when(dummyService.testMethod1()).thenReturn(-1);

        mockedMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(0)));
    }

    @Test
    public void getCountries_shouldReturnAListOf1Item() throws Exception {

        when(dummyService.testMethod2()).thenReturn(-2);

        mockedMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(1)));
    }

    @Test
    public void getCountries_shouldReturnAListOf2Items() throws Exception {

        Country country1 = new Country("Cambodia");
        Country country2 = new Country("Thailand");
        List<Country> countries = new ArrayList<Country>();
        countries.add(country1);
        countries.add(country2);

        when(locationService.getCountries()).thenReturn(countries);

        mockedMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(2)));
    }

}
