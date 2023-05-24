package druginfo.service.read.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table(value = "drugbank05_pill_images_detail_data")
@Data
@ToString
public class PillData implements Serializable {

    @Id
    @Column(value = "pill_data_id")
    String pillDataId;

    @Column(value = "pill_image_path")
    String pillImagePath;

    @Column(value = "pill_overview")
    String pillInfo;

    @Column(value = "pill_shape")
    String pillShape;

    @Column(value = "pill_size")
    String pillSize;

    @Column(value = "pill_colors")
    String pillColors;

    @Column(value = "pill_imprints")
    String pillImprints;


    public PillData() {
    }

    public String getPillDataId() {
        return pillDataId;
    }

    public void setPillDataId(String pillDataId) {
        this.pillDataId = pillDataId;
    }

    public String getPillImagePath() {
        return pillImagePath;
    }

    public void setPillImagePath(String pillImagePath) {
        this.pillImagePath = pillImagePath;
    }

    public String getPillInfo() {
        return pillInfo;
    }

    public void setPillInfo(String pillInfo) {
        this.pillInfo = pillInfo;
    }

    public String getPillShape() {
        return pillShape;
    }

    public void setPillShape(String pillShape) {
        this.pillShape = pillShape;
    }

    public String getPillSize() {
        return pillSize;
    }

    public void setPillSize(String pillSize) {
        this.pillSize = pillSize;
    }

    public String getPillColors() {
        return pillColors;
    }

    public void setPillColors(String pillColors) {
        this.pillColors = pillColors;
    }

    public String getPillImprints() {
        return pillImprints;
    }

    public void setPillImprints(String pillImprints) {
        this.pillImprints = pillImprints;
    }
}
