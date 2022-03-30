package api.location.controller;

import java.util.List;
import api.location.domain.Country;
import api.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return locationService.getCountries();
    }
}
