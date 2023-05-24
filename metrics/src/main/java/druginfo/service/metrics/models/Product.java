package druginfo.service.metrics.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "drugbank05_drugs_products")
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @javax.persistence.Column(name = "product_id", nullable = false)
    private String productID;

    @Column(name = "drugbank_id")
    private String drugbankID;

    @Column(name = "productname")
    private String productName;

    @Column(name = "productlabeller")
    private String productLabeller;

    @Column(name = "productcode")
    private String productCode;

    @Column(name = "productroute")
    private String productRoute;

    @Column(name = "productstrength")
    private String productStrength;

    @Column(name = "productdosage")
    private String productdosage;

    @Column(name = "approved")
    private String approved;

    @Column(name = "otc")
    private String otc;

    @Column(name = "generic")
    private String generic;

    @Column(name = "country")
    private String country;

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
}
