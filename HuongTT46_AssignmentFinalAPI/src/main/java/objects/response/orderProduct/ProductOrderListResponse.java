package objects.response.orderProduct;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOrderListResponse {
    @JsonProperty("data")
    private List<ProductOrderResponse> data;

    public List<ProductOrderResponse> getData() {
        return data;
    }

    public void setData(List<ProductOrderResponse> data) {
        this.data = data;
    }
}
