package druginfo.service.metrics.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Table(name = "drugbank05_recent_request")
@Entity
public class SearchObject implements Serializable {

    @Id
    @Column(name = "request_id")
    private String request_id;

    @Column(name = "timestamp")
    private long timestamp;

    @Column(name = "item_id")
    private String item_id;

    @Column(name = "item_name")
    private String item_name;

    public SearchObject() {
    }

    public SearchObject(String itemName) {
        this.timestamp = Instant.now().toEpochMilli() / 1000;
        this.request_id = UUID.randomUUID().toString();
        this.item_id = UUID.randomUUID().toString();
        this.item_name = itemName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
