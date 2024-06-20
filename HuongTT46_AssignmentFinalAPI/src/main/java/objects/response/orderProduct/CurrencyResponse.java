package objects.response.orderProduct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {
    @JsonProperty("title")
    private String title;

    @JsonProperty("exchange_rate")
    private String exchangeRate;

    @JsonProperty("country_id")
    private CountryResponse country;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public CountryResponse getCountry() {
        return country;
    }

    public void setCountry(CountryResponse country) {
        this.country = country;
    }
}
