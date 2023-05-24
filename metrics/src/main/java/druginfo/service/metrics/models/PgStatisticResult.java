package druginfo.service.metrics.models;

import lombok.Data;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pg_stat_user_tables")
@Entity
public class PgStatisticResult implements Serializable {
    public String getPgTableId() {
        return pgTableId;
    }

    public void setPgTableId(String pgTableId) {
        this.pgTableId = pgTableId;
    }

    @Id
    @Column(name = "relid")
    public String pgTableId;

    @Column(name = "relname")
    public String pgTableName;

    @Column(name = "n_tup_ins")
    public long pgTableInsertCount;

    @Column(name = "n_tup_upd")
    public long pgTableUpdateCount;

    @Column(name = "n_tup_del")
    public long pgTableDeleteCount;

    @Column(name = "seq_scan")
    public long pgSeqScan;

    @Column(name = "seq_tup_read")
    public long pgSeqTupRead;

    public long getPgSeqScan() {
        return pgSeqScan;
    }

    public void setPgSeqScan(long pgSeqScan) {
        this.pgSeqScan = pgSeqScan;
    }

    public long getPgSeqTupRead() {
        return pgSeqTupRead;
    }

    public void setPgSeqTupRead(long pgSeqTupRead) {
        this.pgSeqTupRead = pgSeqTupRead;
    }

    public String getPgTableName() {
        return pgTableName;
    }

    public void setPgTableName(String pgTableName) {
        this.pgTableName = pgTableName;
    }

    public long getPgTableInsertCount() {
        return pgTableInsertCount;
    }

    public void setPgTableInsertCount(long pgTableInsertCount) {
        this.pgTableInsertCount = pgTableInsertCount;
    }

    public long getPgTableUpdateCount() {
        return pgTableUpdateCount;
    }

    public void setPgTableUpdateCount(long pgTableUpdateCount) {
        this.pgTableUpdateCount = pgTableUpdateCount;
    }

    public long getPgTableDeleteCount() {
        return pgTableDeleteCount;
    }

    public void setPgTableDeleteCount(long pgTableDeleteCount) {
        this.pgTableDeleteCount = pgTableDeleteCount;
    }
}
