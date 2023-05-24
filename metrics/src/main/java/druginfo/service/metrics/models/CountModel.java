package druginfo.service.metrics.models;

import javax.persistence.Column;

public class CountModel {

    @Column(name = "table_total_row")
    public String totalRowByTable;

    @Column(name = "count")
    public Long countResult;

    public String getTotalRowByTable() {
        return totalRowByTable;
    }

    public void setTotalRowByTable(String totalRowByTable) {
        this.totalRowByTable = totalRowByTable;
    }

    public Long getCountResult() {
        return countResult;
    }

    public void setCountResult(Long countResult) {
        this.countResult = countResult;
    }
}
