package druginfo.service.metrics.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "drugbank05_drugs_general_info_full")
@Entity
public class ProductGeneralInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @Column(name = "drugbank_id", nullable = false)
    private String Id;

    @Column(name = "drugname")
    private String drugName;

    @Column(name = "drugdescription")
    private String drugDescription;

    @Column(name = "drugstate")
    private String drugState;

    @Column(name = "drugindication")
    private String drugIndication;

    @Column(name = "drugpharmaco")
    private String drugPharmaco;

    @Column(name = "drugmechan")
    private String drugMechan;

    @Column(name = "drugtoxicity")
    private String drugToxicity;

    @Column(name = "drugmetabo")
    private String drugMetabo;

    @Column(name = "drughalflife")
    private String drugHalflife;

    @Column(name = "drugelimination")
    private String drugLimination;

    @Column(name = "drugclearance")
    private String drugClearance;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getDrugMetabo() {
        return drugMetabo;
    }

    public void setDrugMetabo(String drugMetabo) {
        this.drugMetabo = drugMetabo;
    }

    public String getDrugHalflife() {
        return drugHalflife;
    }

    public void setDrugHalflife(String drugHalflife) {
        this.drugHalflife = drugHalflife;
    }

    public String getDrugLimination() {
        return drugLimination;
    }

    public void setDrugLimination(String drugLimination) {
        this.drugLimination = drugLimination;
    }

    public String getDrugClearance() {
        return drugClearance;
    }

    public void setDrugClearance(String drugClearance) {
        this.drugClearance = drugClearance;
    }
}
