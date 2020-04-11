package pl.kietlinski.springbootmapsapi.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(MockitoJUnitRunner.class)
class CityLattlongServiceTest {

    @Spy
    CityLattlongService cityLattlongService = new CityLattlongService();

    @Test
    void should_convert_city_name_to_coordinates() throws URISyntaxException {
        //when
        String example = cityLattlongService.getConvertCityNameToCoordinates("London");
        //then
        Assert.assertEquals(example, "0,0");
    }

    @Test
    void should_get_uri() throws URISyntaxException {
        //when
        URI example = cityLattlongService.getApiUri("London");
        //then
        Assert.assertEquals(example.toString(),
                "https://maps.googleapis.com/maps/api/place/findplacefromtext/json" +
                        "?input=London" +
                        "&inputtype=textquery&fields=formatted_address%2Cgeometry&key");
    }
}