package druginfo.autocorrectsearch.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "drugs")
@Setting(settingPath = "es-config/elastic-analyzer.json")
@Getter
@Setter
public class Drug {

    @Id
    private String drugbank_ID;
    private String drugName;
    private String drugDescription;
    private String drugState;
    private String drugIndication;
    private String drugPharmaco;
    private String drugMechan;
    private String drugToxicity;
    private String drugMetabolism;
    private String drugHalflife;
    private String drugElimination;
    private String drugClearance;
}
