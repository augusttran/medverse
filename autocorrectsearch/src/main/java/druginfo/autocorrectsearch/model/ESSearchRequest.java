package druginfo.autocorrectsearch.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ESSearchRequest {

    private String keyword;

    public static ESSearchRequest of(String keyword) {
        return ESSearchRequest.builder()
                .keyword(keyword)
                .build();
    }
}