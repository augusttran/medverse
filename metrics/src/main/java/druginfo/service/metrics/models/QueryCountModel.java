package druginfo.service.metrics.models;

import javax.persistence.Column;
import javax.persistence.Entity;

public class QueryCountModel {

    @Column(name = "query_count")
    public String countByQuery;

    @Column(name = "count")
    public Long countResult;

    public String getCountByQuery() {
        return countByQuery;
    }

    public void setCountByQuery(String countByQuery) {
        this.countByQuery = countByQuery;
    }

    public Long getCountResult() {
        return countResult;
    }

    public void setCountResult(Long countResult) {
        this.countResult = countResult;
    }
}
