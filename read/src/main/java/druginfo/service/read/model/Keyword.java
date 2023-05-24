package druginfo.service.read.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table(value = "drugbank05_recent_searches")
@Data
@Getter
public class Keyword implements Serializable {

}
