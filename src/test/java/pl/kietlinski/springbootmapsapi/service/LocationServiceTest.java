package pl.kietlinski.springbootmapsapi.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import pl.kietlinski.springbootmapsapi.dto.ResultDTO;

import java.net.URISyntaxException;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class LocationServiceTest {

    @Spy
    LocationService locationService = new LocationService(new ModelMapper());

    @Test
    void should_get_resultdto_list() throws URISyntaxException {
        //when
        List<ResultDTO> apiResults = locationService
                .getApiResults("City", "Radius", "Type");
        //then
        Assert.assertEquals(apiResults.size(), 1);
        Assert.assertEquals(apiResults.get(0).getName(), "No result");
    }
}