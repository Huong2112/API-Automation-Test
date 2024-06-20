package objects.response.orderDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAddressResponse {
    @JsonProperty("id")
    private String addressId;

    @JsonProperty("country_id")
    private CountryResponse country;

    @JsonProperty("state_id")
    private StateResponse state;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public CountryResponse getCountry() {
        return country;
    }

    public void setCountry(CountryResponse country) {
        this.country = country;
    }

    public StateResponse getState() {
        return state;
    }

    public void setState(StateResponse state) {
        this.state = state;
    }
}
