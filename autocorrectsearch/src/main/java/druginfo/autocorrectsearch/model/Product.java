package druginfo.autocorrectsearch.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "products-reindex-2")
@Setting(settingPath = "es-config/elastic-analyzer.json")
@Getter
@Setter
public class Product {

    @Id
    @Field(type = FieldType.Keyword)
    private String productID;

    @Field(type = FieldType.Search_As_You_Type, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
    private String name;

    @Field(type = FieldType.Text)
    private String labeller;
    private Float hitScore;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabeller() {
        return labeller;
    }

    public void setLabeller(String labeller) {
        this.labeller = labeller;
    }

    public Float getHitScore() {
        return hitScore;
    }

    public void setHitScore(Float hitScore) {
        this.hitScore = hitScore;
    }
}
