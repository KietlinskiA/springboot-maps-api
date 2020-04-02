
package pl.kietlinski.springbootmapsapi.model.location;

import lombok.Data;
import pl.kietlinski.springbootmapsapi.model.Location;

@Data
@SuppressWarnings("unused")
public class Geometry {

    private Location location;
    private Viewport viewport;

}
