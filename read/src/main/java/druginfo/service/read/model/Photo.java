package druginfo.service.read.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table(value = "drugbank05_pill_images_directory")
@Data
@Getter
public class Photo implements Serializable {

    @Id
    @Column(value = "ndc11")
    private String ndc11Code;
    @Column(value = "rxcui")
    private String rxcuiStr;
    @Column(value = "rxname")
    private String rxName;
    @Column(value = "rxnavimageobjectid")
    private String rxnavImageObjectId;
    @Column(value = "rxnavimagefilename")
    private String rxnavImageFilename;
    @Column(value = "nlmimagefilename")
    private String nlmImageFilename;

    @Column(value = "rxnav120")
    private String rxnav120;
    @Column(value = "rxbase120")
    private String rxbase120;

    @Column(value = "rxnav300")
    private String rxnav300;
    @Column(value = "rxbase300")
    private String rxbase300;

    @Column(value = "rxnav600")
    private String rxnav600;
    @Column(value = "rxbase600")
    private String rxbase600;

    @Column(value = "rxnav800")
    private String rxnav800;
    @Column(value = "rxbase800")
    private String rxbase800;

    @Column(value = "rxnav1024")
    private String rxnav1024;
    @Column(value = "rxbase1024")
    private String rxbase1024;

    @Column(value = "rxnavoriginal")
    private String rxnavoriginal;
    @Column(value = "rxbaseoriginal")
    private String rxbaseoriginal;

    public Photo() {
    }

    public String getNdc11Code() {
        return ndc11Code;
    }

    public void setNdc11Code(String ndc11Code) {
        this.ndc11Code = ndc11Code;
    }

    public String getRxcuiStr() {
        return rxcuiStr;
    }

    public void setRxcuiStr(String rxcuiStr) {
        this.rxcuiStr = rxcuiStr;
    }

    public String getRxName() {
        return rxName;
    }

    public void setRxName(String rxName) {
        this.rxName = rxName;
    }

    public String getRxnavImageObjectId() {
        return rxnavImageObjectId;
    }

    public void setRxnavImageObjectId(String rxnavImageObjectId) {
        this.rxnavImageObjectId = rxnavImageObjectId;
    }

    public String getRxnavImageFilename() {
        return rxnavImageFilename;
    }

    public void setRxnavImageFilename(String rxnavImageFilename) {
        this.rxnavImageFilename = rxnavImageFilename;
    }

    public String getNlmImageFilename() {
        return nlmImageFilename;
    }

    public void setNlmImageFilename(String nlmImageFilename) {
        this.nlmImageFilename = nlmImageFilename;
    }

    public String getRxnav120() {
        return rxnav120;
    }

    public void setRxnav120(String rxnav120) {
        this.rxnav120 = rxnav120;
    }

    public String getRxbase120() {
        return rxbase120;
    }

    public void setRxbase120(String rxbase120) {
        this.rxbase120 = rxbase120;
    }

    public String getRxnav300() {
        return rxnav300;
    }

    public void setRxnav300(String rxnav300) {
        this.rxnav300 = rxnav300;
    }

    public String getRxbase300() {
        return rxbase300;
    }

    public void setRxbase300(String rxbase300) {
        this.rxbase300 = rxbase300;
    }

    public String getRxnav600() {
        return rxnav600;
    }

    public void setRxnav600(String rxnav600) {
        this.rxnav600 = rxnav600;
    }

    public String getRxbase600() {
        return rxbase600;
    }

    public void setRxbase600(String rxbase600) {
        this.rxbase600 = rxbase600;
    }

    public String getRxnav800() {
        return rxnav800;
    }

    public void setRxnav800(String rxnav800) {
        this.rxnav800 = rxnav800;
    }

    public String getRxbase800() {
        return rxbase800;
    }

    public void setRxbase800(String rxbase800) {
        this.rxbase800 = rxbase800;
    }

    public String getRxnav1024() {
        return rxnav1024;
    }

    public void setRxnav1024(String rxnav1024) {
        this.rxnav1024 = rxnav1024;
    }

    public String getRxbase1024() {
        return rxbase1024;
    }

    public void setRxbase1024(String rxbase1024) {
        this.rxbase1024 = rxbase1024;
    }

    public String getRxnavoriginal() {
        return rxnavoriginal;
    }

    public void setRxnavoriginal(String rxnavoriginal) {
        this.rxnavoriginal = rxnavoriginal;
    }

    public String getRxbaseoriginal() {
        return rxbaseoriginal;
    }

    public void setRxbaseoriginal(String rxbaseoriginal) {
        this.rxbaseoriginal = rxbaseoriginal;
    }
}
