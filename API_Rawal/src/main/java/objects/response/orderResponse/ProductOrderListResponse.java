package objects.response.orderResponse;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOrderListResponse {
    @JsonProperty("data")
    private List<ProductOrderResponse> productOrderResponses;

    public List<ProductOrderResponse> getProductOrderResponses() {
        return productOrderResponses;
    }

    public void setProductOrderResponses(List<ProductOrderResponse> productOrderResponses) {
        this.productOrderResponses = productOrderResponses;
    }
}
