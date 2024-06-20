package objects.response.orderProduct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty("currency_id")
    private CurrencyResponse currencyId;

    public CurrencyResponse getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(CurrencyResponse currencyId) {
        this.currencyId = currencyId;
    }

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

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }
}
