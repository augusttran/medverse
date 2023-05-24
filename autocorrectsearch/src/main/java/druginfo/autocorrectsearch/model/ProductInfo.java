package druginfo.autocorrectsearch.model;

import org.springframework.data.annotation.Id;

public class ProductInfo {

    @Id
    private String productID;
    private String drugbankID;
    private String productName;
    private String productLabeller;
    private String productCode;
    private String productRoute;
    private String productStrength;
    private String productdosage;
    private String approved;
    private String otc;
    private String generic;
    private String country;
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
