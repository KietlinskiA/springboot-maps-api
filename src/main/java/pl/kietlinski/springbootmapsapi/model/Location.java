
package pl.kietlinski.springbootmapsapi.model;

import lombok.Data;
import pl.kietlinski.springbootmapsapi.model.location.Result;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class Location {

    private List<Object> htmlAttributions;
    private double lat;
    private double lng;
    private List<Result> results;
    private String status;

}
