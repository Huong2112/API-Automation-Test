package objects.response.productItemCompare;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductComparedResponse {
    @JsonProperty("data")
    private List<ProductCompare> data;

    public List<ProductCompare> getData() {
        return data;
    }

    public void setData(List<ProductCompare> data) {
        this.data = data;
    }
}
