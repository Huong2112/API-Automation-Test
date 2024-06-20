package objects.response.paymentMethod;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodResponse {

    @JsonProperty("payment_method_id")
    private String id;

    @JsonProperty("payment_method_name")
    private String name;

    @JsonProperty("payment_method_type")
    private String type;

    @JsonProperty("payment_method_title")
    private String title;


    @JsonProperty("payment_method_status")
    private String status;

    @JsonProperty("payment_method_environment")
    private String environment;

    @JsonProperty("default")
    private String deValue;



    @JsonProperty("payment_setting")
    private List<PaymentSettingResponse> paymentSetting;


    public List<PaymentSettingResponse> getPaymentSetting() {
        return paymentSetting;
    }

    public void setPaymentSetting(List<PaymentSettingResponse> paymentSetting) {
        this.paymentSetting = paymentSetting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public List<PaymentSettingResponse> getPaymentSetting() {
//        return paymentSetting;
//    }
//
//    public void setPaymentSetting(List<PaymentSettingResponse> paymentSetting) {
//        this.paymentSetting = paymentSetting;
//    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDeValue() {
        return deValue;
    }

    public void setDeValue(String deValue) {
        this.deValue = deValue;
    }
}
