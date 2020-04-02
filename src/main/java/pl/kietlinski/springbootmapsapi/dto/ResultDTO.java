package pl.kietlinski.springbootmapsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
    private String icon;
    private String name;
    private double rating;
    private String vicinity;
}
