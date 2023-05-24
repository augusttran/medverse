package druginfo.service.read.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table(value = "drugbank05_drugs_general_info_full")
@Data
@ToString
public class Drug implements Serializable {

    @Id
    @Column(value = "drugbank_id")
    private String drugbank_ID;

    @Column(value = "drugname")
    private String drugName;
    @Column(value = "drugdescription")
    private String drugDescription;
    @Column(value = "drugstate")
    private String drugState;
    @Column(value = "drugindication")
    private String drugIndication;
    @Column(value = "drugpharmaco")
    private String drugPharmaco;
    @Column(value = "drugmechan")
    private String drugMechan;
    @Column(value = "drugtoxicity")
    private String drugToxicity;
    @Column(value = "drugmetabo")
    private String drugMetabolism;
    @Column(value = "drughalflife")
    private String drugHalflife;
    @Column(value = "drugelimination")
    private String drugElimination;
    @Column(value = "drugclearance")
    private String drugClearance;

    public Drug() {
    }

    public Drug(String drugbank_ID, String drugName, String drugDescription, String drugState, String drugIndication,
            String drugPharmaco, String drugMechan, String drugToxicity, String drugMetabolism, String drugHalflife,
            String drugElimination, String drugClearance) {
        this.drugbank_ID = drugbank_ID;
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugState = drugState;
        this.drugIndication = drugIndication;
        this.drugPharmaco = drugPharmaco;
        this.drugMechan = drugMechan;
        this.drugToxicity = drugToxicity;
        this.drugMetabolism = drugMetabolism;
        this.drugHalflife = drugHalflife;
        this.drugElimination = drugElimination;
        this.drugClearance = drugClearance;
    }

    public String getDrugbank_ID() {
        return drugbank_ID;
    }

    public void setDrugbank_ID(String drugbank_ID) {
        this.drugbank_ID = drugbank_ID;
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
