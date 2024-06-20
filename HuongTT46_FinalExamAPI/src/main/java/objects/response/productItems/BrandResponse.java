package objects.response.productItems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandResponse {
    @JsonProperty("id")
    private String brandId;

    @JsonProperty("name")
    private String brandName;


    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\''
               ;
    }
}
