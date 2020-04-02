
package pl.kietlinski.springbootmapsapi.model.location;

import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class Result {

    private Geometry geometry;
    private String icon;
    private String id;
    private String name;
    private OpeningHours openingHours;
    private List<Photo> photos;
    private String placeId;
    private PlusCode plusCode;
    private double rating;
    private String reference;
    private String scope;
    private List<String> types;
    private long userRatingsTotal;
    private String vicinity;

}
