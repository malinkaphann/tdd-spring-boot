package api.location.controller;

import java.util.ArrayList;
import java.util.List;
import api.location.domain.Country;
import api.location.service.DummyService;
import api.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    DummyService dummyService;

    @GetMapping("/countries")
    public List<Country> getCountries() {

        int status1 = dummyService.testMethod1();
        if (status1 == -1) {
            return new ArrayList<Country>();
        }

        int status2 = dummyService.testMethod2();
        if (status2 == -2) {
            Country country = new Country("Cambodia");
            List<Country> countries = new ArrayList<Country>();
            return countries;
        }

        return locationService.getCountries();
    }
}
