package objects.response.productItems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductItemsResponse {
    @JsonProperty("data")
    private List<ProductResponse> data;

    public List<ProductResponse> getData() {
        return data;
    }

    public void setData(List<ProductResponse> data) {
        this.data = data;
    }
}
