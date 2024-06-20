package objects.response.orderResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOrderResponse {
    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("warehouse_id")
    private String warehouseID;

    @JsonProperty("order_from")
    private String orderFrom;

    @JsonProperty("delivery_state")
    private String deliveryState;

    @JsonProperty("delivery_phone")
    private String deliveryPhone;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    public String getOrderForm() {
        return orderFrom;
    }

    public void setOrderForm(String orderForm) {
        this.orderFrom = orderForm;
    }
}
