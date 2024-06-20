package objects.response.orderDetail;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse {

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("customer_id")
    private CustomerDetailResponse customer;

    @JsonProperty("order_from")
    private String orderFrom;

    @JsonProperty("shipping_method")
    private String shippingMethod;

    @JsonProperty("order_status")
    private String orderStatus;

    @JsonProperty("order_detail")
    private List<OrderDetailResponse> orderDetail;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public CustomerDetailResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetailResponse customer) {
        this.customer = customer;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderDetailResponse> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetailResponse> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
