package pl.kietlinski.springbootmapsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kietlinski.springbootmapsapi.service.CityLattlongService;
import pl.kietlinski.springbootmapsapi.service.LocationService;

import java.net.URISyntaxException;

@Controller
@RequestMapping("/api")
public class LocationViewController {

    private LocationService locationService;
    private CityLattlongService cityLattlongService;

    @Autowired
    public LocationViewController(LocationService locationService, CityLattlongService cityLattlongService) {
        this.locationService = locationService;
        this.cityLattlongService = cityLattlongService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("resultList", locationService.getResultDTOList());

        return "Maps";
    }

    @PostMapping
    public String findLocationsByParams(
            @RequestParam(defaultValue = "gas_station") String type,
            @RequestParam(defaultValue = "Warsaw") String locationName,
            @RequestParam(defaultValue = "0") String radius
    ) throws URISyntaxException {
        locationService.getApiResults(
                cityLattlongService.getConvertCityNameToCoordinates(locationName),
                radius,
                type
        );

        return "redirect:/api";
    }
}
