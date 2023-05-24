package druginfo.service.read.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;

@Data
@ToString
public class TrendPillData implements Serializable {

    @Id
    @Column(value = "trend_pill_id")
    String trendPillID;

    @Column(value = "trend_id")
    String trendId;

    @Column(value = "pill_data_id")
    String pillRxNavImageObjectId;

    @Column(value = "rxname")
    String pillOverviewData;

    @Column(value = "rxnavimagefilename")
    String rxnavImageFilename;

    public String getTrendPillID() {
        return trendPillID;
    }

    public void setTrendPillID(String trendPillID) {
        this.trendPillID = trendPillID;
    }

    public String getTrendId() {
        return trendId;
    }

    public void setTrendId(String trendId) {
        this.trendId = trendId;
    }

    public String getPillRxNavImageObjectId() {
        return pillRxNavImageObjectId;
    }

    public void setPillRxNavImageObjectId(String pillRxNavImageObjectId) {
        this.pillRxNavImageObjectId = pillRxNavImageObjectId;
    }

    public String getPillOverviewData() {
        return pillOverviewData;
    }

    public void setPillOverviewData(String pillOverviewData) {
        this.pillOverviewData = pillOverviewData;
    }

    public String getRxnavImageFilename() {
        return rxnavImageFilename;
    }

    public void setRxnavImageFilename(String rxnavImageFilename) {
        this.rxnavImageFilename = rxnavImageFilename;
    }
}
