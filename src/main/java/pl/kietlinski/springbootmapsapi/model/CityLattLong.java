
package pl.kietlinski.springbootmapsapi.model;

import com.fasterxml.jackson.annotation.*;
import pl.kietlinski.springbootmapsapi.model.cityLattLong.Candidate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "candidates",
    "status"
})
public class CityLattLong {

    @JsonProperty("candidates")
    private List<Candidate> candidates = null;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CityLattLong() {
    }

    /**
     * 
     * @param candidates
     * @param status
     */
    public CityLattLong(List<Candidate> candidates, String status) {
        super();
        this.candidates = candidates;
        this.status = status;
    }

    @JsonProperty("candidates")
    public List<Candidate> getCandidates() {
        return candidates;
    }

    @JsonProperty("candidates")
    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
