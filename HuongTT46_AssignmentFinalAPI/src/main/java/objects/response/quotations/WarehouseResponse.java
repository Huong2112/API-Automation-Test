package objects.response.quotations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseResponse {
    @JsonProperty("warehouse_name")
    private String warehouseName;

    @JsonProperty("warehouse_id")
    private int warehouseId;

    @JsonProperty("warehouse_code")
    private String warehouseCode;


    @JsonProperty("warehouse_address")
    private String warehouseAddress;

    @JsonProperty("warehouse_phone")
    private String warehousePhone;

    @JsonProperty("warehouse_email")
    private String warehouseEmail;

    @JsonProperty("warehouse_status")
    private String warehouseStatus;

    @JsonProperty("warehouse_state_id")
    private String warehouseStateId;

    @JsonProperty("warehouse_country_id")
    private String warehouseCountryId;

    @JsonProperty("warehouse_tax")
    private List<Object> warehouseTax;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    public String getWarehouseEmail() {
        return warehouseEmail;
    }

    public void setWarehouseEmail(String warehouseEmail) {
        this.warehouseEmail = warehouseEmail;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public String getWarehouseStateId() {
        return warehouseStateId;
    }

    public void setWarehouseStateId(String warehouseStateId) {
        this.warehouseStateId = warehouseStateId;
    }

    public String getWarehouseCountryId() {
        return warehouseCountryId;
    }

    public void setWarehouseCountryId(String warehouseCountryId) {
        this.warehouseCountryId = warehouseCountryId;
    }

    public List<Object> getWarehouseTax() {
        return warehouseTax;
    }

    public void setWarehouseTax(List<Object> warehouseTax) {
        this.warehouseTax = warehouseTax;
    }

    public String getWarehouse_Name() {
        return warehouseName;
    }

    public void setWarehouse_Name(String warehouse_Name) {
        this.warehouseName = warehouse_Name;
    }

    @Override
    public String toString() {
        return "WarehouseResponse{" +
                "warehouseName='" + warehouseName  +
                ", warehouseId=" + warehouseId +
                ", warehouseCode='" + warehouseCode  +
                ", warehouseAddress='" + warehouseAddress  +
                ", warehousePhone='" + warehousePhone  +
                ", warehouseEmail='" + warehouseEmail  +
                ", warehouseStatus='" + warehouseStatus  +
                ", warehouseStateId='" + warehouseStateId +
                ", warehouseCountryId='" + warehouseCountryId +
                ", warehouseTax=" + warehouseTax +
                '}';
    }
}
