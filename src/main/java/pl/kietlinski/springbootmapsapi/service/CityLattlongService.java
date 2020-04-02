package pl.kietlinski.springbootmapsapi.service;

import lombok.Data;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kietlinski.springbootmapsapi.model.CityLattLong;
import pl.kietlinski.springbootmapsapi.model.cityLattLong.Candidate;
import pl.kietlinski.springbootmapsapi.model.cityLattLong.Location;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@Data
public class CityLattlongService {

    @Value("${api-key}")
    private String key;

    private static final String LATTLONG_BASE_URL = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json";

    public String getConvertCityNameToCoordinates(String newCityName) throws URISyntaxException {
        CityLattLong cityLattLong = new RestTemplate().getForObject(
                getApiUri(newCityName),
                CityLattLong.class
        );

        if(cityLattLong == null || cityLattLong.getCandidates() == null || cityLattLong.getCandidates().size() == 0){
            return "0,0";
        }

        Location location = cityLattLong.getCandidates().get(0).getGeometry().getLocation();

        if(cityLattLong.getStatus().equals("OK")){
            return location.getLat() + "," + location.getLng();
        } else {
            return "0,0";
        }
    }

    public URI getApiUri(String query) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(LATTLONG_BASE_URL);
        uriBuilder.addParameter("input", query);
        uriBuilder.addParameter("inputtype", "textquery");
        uriBuilder.addParameter("fields", "formatted_address,geometry");
        uriBuilder.addParameter("key", key);
        return uriBuilder.build();
    }
}
