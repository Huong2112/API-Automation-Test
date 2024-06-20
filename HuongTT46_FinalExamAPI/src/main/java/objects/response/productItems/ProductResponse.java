package objects.response.productItems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {
    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("category_id")
    private String categoryId;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private String price;

    @JsonProperty("brand")
    private BrandResponse brand;

    public BrandResponse getBrand() {
        return brand;
    }

    public void setBrand(BrandResponse brand) {
        this.brand = brand;
    }

    public String getProductId() {
        return productId;
    }


    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "productId='" + productId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", " +  brand.toString();
    }
}
