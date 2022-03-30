package api.location.service;

import api.location.domain.Country;
import api.location.repository.LocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(final LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Country> getCountries() {
        return locationRepository.findAll();
    }
}
