package objects.response.orderDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("product")
    private ProductDetailResponse product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductDetailResponse getProduct() {
        return product;
    }

    public void setProduct(ProductDetailResponse product) {
        this.product = product;
    }
}
