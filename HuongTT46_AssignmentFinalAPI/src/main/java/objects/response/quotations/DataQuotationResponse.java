package objects.response.quotations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataQuotationResponse {
    @JsonProperty("data")
    private List<QuotationResponse> data;

    public List<QuotationResponse> getData() {
        return data;
    }

    public void setData(List<QuotationResponse> data) {
        this.data = data;
    }
}
