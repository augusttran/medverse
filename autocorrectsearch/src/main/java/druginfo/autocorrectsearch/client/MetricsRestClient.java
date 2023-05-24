package druginfo.autocorrectsearch.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MetricsRestClient {

    private WebClient webClient;

    public MetricsRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Value("${restClient.reviewsUrl}")
    private String reviewsUrl;

}
