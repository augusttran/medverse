package druginfo.service.read.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table(value = "drugbank05_drugs_interactions")
@Data
@ToString
public class Interaction implements Serializable {

    @Id
    @Column(value = "interaction_id")
    private String interactionId;

    @Column(value = "drugbank_id_1")
    private String firstDrugId;

    @Column(value = "drugbank_id_2")
    private String secondDrugId;

    @Column(value = "drug_2_name")
    private String secondDrugName;

    @Column(value = "interaction_description")
    private String interactionDescription;

    public Interaction() {
    }

    public Interaction(String interactionId, String firstDrugId, String secondDrugId, String secondDrugName,
            String interactionDescription) {
        this.interactionId = interactionId;
        this.firstDrugId = firstDrugId;
        this.secondDrugId = secondDrugId;
        this.secondDrugName = secondDrugName;
        this.interactionDescription = interactionDescription;
    }

    public String getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(String interactionId) {
        this.interactionId = interactionId;
    }

    public String getFirstDrugId() {
        return firstDrugId;
    }

    public void setFirstDrugId(String firstDrugId) {
        this.firstDrugId = firstDrugId;
    }

    public String getSecondDrugId() {
        return secondDrugId;
    }

    public void setSecondDrugId(String secondDrugId) {
        this.secondDrugId = secondDrugId;
    }

    public String getSecondDrugName() {
        return secondDrugName;
    }

    public void setSecondDrugName(String secondDrugName) {
        this.secondDrugName = secondDrugName;
    }

    public String getInteractionDescription() {
        return interactionDescription;
    }

    public void setInteractionDescription(String interactionDescription) {
        this.interactionDescription = interactionDescription;
    }
}
