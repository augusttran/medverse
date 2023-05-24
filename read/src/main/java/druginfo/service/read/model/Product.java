package druginfo.service.read.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

import java.io.Serializable;

@Table(value = "drugbank05_drugs_products")
@Data
@ToString
public class Product implements Serializable {

    @Id
    @Column(value = "product_id")
    private String productID;
    @Column(value = "drugbank_id")
    private String drugbankID;
    @Column(value = "productname")
    private String productName;
    @Column(value = "productlabeller")
    private String productLabeller;
    @Column(value = "productcode")
    private String productCode;
    @Column(value = "productroute")
    private String productRoute;
    @Column(value = "productstrength")
    private String productStrength;
    @Column(value = "productdosage")
    private String productdosage;
    @Column(value = "approved")
    private String approved;
    @Column(value = "otc")
    private String otc;
    @Column(value = "generic")
    private String generic;
    @Column(value = "country")
    private String country;

    @Column(value="drugname")
    private String drugName;
    @Column(value="drugdescription")
    private String drugDescription;
    @Column(value="drugstate")
    private String drugState;
    @Column(value="drugindication")
    private String drugIndication;
    @Column(value="drugpharmaco")
    private String drugPharmaco;
    @Column(value="drugmechan")
    private String drugMechan;
    @Column(value="drugtoxicity")
    private String drugToxicity;
    @Column(value="drugmetabo")
    private String drugMetabolism;
    @Column(value="drughalflife")
    private String drugHalflife;
    @Column(value="drugelimination")
    private String drugElimination;
    @Column(value="drugclearance")
    private String drugClearance;


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDrugbankID() {
        return drugbankID;
    }

    public void setDrugbankID(String drugbankID) {
        this.drugbankID = drugbankID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLabeller() {
        return productLabeller;
    }

    public void setProductLabeller(String productLabeller) {
        this.productLabeller = productLabeller;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductRoute() {
        return productRoute;
    }

    public void setProductRoute(String productRoute) {
        this.productRoute = productRoute;
    }

    public String getProductStrength() {
        return productStrength;
    }

    public void setProductStrength(String productStrength) {
        this.productStrength = productStrength;
    }

    public String getProductdosage() {
        return productdosage;
    }

    public void setProductdosage(String productdosage) {
        this.productdosage = productdosage;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getOtc() {
        return otc;
    }

    public void setOtc(String otc) {
        this.otc = otc;
    }

    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugDescription() {
        return drugDescription;
    }

    public void setDrugDescription(String drugDescription) {
        this.drugDescription = drugDescription;
    }

    public String getDrugState() {
        return drugState;
    }

    public void setDrugState(String drugState) {
        this.drugState = drugState;
    }

    public String getDrugIndication() {
        return drugIndication;
    }

    public void setDrugIndication(String drugIndication) {
        this.drugIndication = drugIndication;
    }

    public String getDrugPharmaco() {
        return drugPharmaco;
    }

    public void setDrugPharmaco(String drugPharmaco) {
        this.drugPharmaco = drugPharmaco;
    }

    public String getDrugMechan() {
        return drugMechan;
    }

    public void setDrugMechan(String drugMechan) {
        this.drugMechan = drugMechan;
    }

    public String getDrugToxicity() {
        return drugToxicity;
    }

    public void setDrugToxicity(String drugToxicity) {
        this.drugToxicity = drugToxicity;
    }

    public String getDrugMetabolism() {
        return drugMetabolism;
    }

    public void setDrugMetabolism(String drugMetabolism) {
        this.drugMetabolism = drugMetabolism;
    }

    public String getDrugHalflife() {
        return drugHalflife;
    }

    public void setDrugHalflife(String drugHalflife) {
        this.drugHalflife = drugHalflife;
    }

    public String getDrugElimination() {
        return drugElimination;
    }

    public void setDrugElimination(String drugElimination) {
        this.drugElimination = drugElimination;
    }

    public String getDrugClearance() {
        return drugClearance;
    }

    public void setDrugClearance(String drugClearance) {
        this.drugClearance = drugClearance;
    }
}
