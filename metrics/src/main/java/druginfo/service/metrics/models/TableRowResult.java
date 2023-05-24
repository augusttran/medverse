package druginfo.service.metrics.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class TableRowResult {

    @Id
    @Column(name = "table_schema")
    public String pgTableSchemas;

    @Column(name = "table_name")
    public String pgTableName;

    @Column(name = "rows")
    public long tableRows;

    public String getPgTableSchemas() {
        return pgTableSchemas;
    }

    public void setPgTableSchemas(String pgTableSchemas) {
        this.pgTableSchemas = pgTableSchemas;
    }

    public String getPgTableName() {
        return pgTableName;
    }

    public void setPgTableName(String pgTableName) {
        this.pgTableName = pgTableName;
    }

    public long getTableRows() {
        return tableRows;
    }

    public void setTableRows(long tableRows) {
        this.tableRows = tableRows;
    }
}
