
package pl.kietlinski.springbootmapsapi.model.location;

import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class Photo {

    private long height;
    private List<String> htmlAttributions;
    private String photoReference;
    private long width;

}
