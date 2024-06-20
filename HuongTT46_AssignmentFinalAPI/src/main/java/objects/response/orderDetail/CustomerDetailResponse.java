package objects.response.orderDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetailResponse {
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_first_name")
    private String firstName;

    @JsonProperty("customer_last_name")
    private String lastName;

    @JsonProperty("customer_status")
    private String customerStatus;

    @JsonProperty("customer_address")
    private List<CustomerAddressResponse> customerAddress;

    public List<CustomerAddressResponse> getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(List<CustomerAddressResponse> customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
}
