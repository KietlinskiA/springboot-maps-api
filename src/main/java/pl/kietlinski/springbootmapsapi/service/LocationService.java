package pl.kietlinski.springbootmapsapi.service;

import lombok.Data;
import org.apache.http.client.utils.URIBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kietlinski.springbootmapsapi.dto.ResultDTO;
import pl.kietlinski.springbootmapsapi.model.Location;
import pl.kietlinski.springbootmapsapi.model.location.Result;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class LocationService {

    @Value("${api-key}")
    private String key;

    private static final String LOCATION_BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    private List<ResultDTO> resultDTOList;
    private ModelMapper modelMapper;

    @Autowired
    public LocationService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.resultDTOList = new ArrayList<>();
    }

    public List<ResultDTO> getApiResults(String locationName, String radius, String type) throws URISyntaxException {
//        if(String.valueOf(radius).equals()){
//            return
//        }
        ResponseEntity<Location> exchange = new RestTemplate().exchange(
                getApiUri(locationName, radius, type),
                HttpMethod.POST,
                HttpEntity.EMPTY,
                Location.class
        );

        List<Result> resultList = exchange.getBody().getResults();
        if(resultDTOList.size() != 0) {
            resultDTOList.clear();
        }

        if (resultList.size() != 0) {
            for(Result result : resultList){
            resultDTOList.add(modelMapper.map(result, ResultDTO.class));
            }
        } else {
            resultDTOList.add(new ResultDTO("","No result",0,""));
        }

        return resultDTOList;
    }

    private URI getApiUri(String locationName, String radius, String type) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(LOCATION_BASE_URL);
        uriBuilder.addParameter("location", locationName);
        uriBuilder.addParameter("radius", radius);
        uriBuilder.addParameter("type", type);
        uriBuilder.addParameter("key", key);

        return uriBuilder.build();
    }
}
