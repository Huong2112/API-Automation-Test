package objects.response.orderDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataOrderDetailResponse {
    @JsonProperty("data")
    private OrderResponse data;

    public OrderResponse getData() {
        return data;
    }

    public void setData(OrderResponse data) {
        this.data = data;
    }
}
