
package druginfo.autocorrectsearch.client;

import druginfo.autocorrectsearch.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ProductInfoRestClient {

    @Autowired
    private WebClient webClient;

    @Value("${restClient.productInfoUrl}")
    private String productInfoUrl;

    public ProductInfoRestClient(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<ProductInfo> retrieveProductInfo(String productId){
        var url = productInfoUrl.concat(("/{id}"));
        return webClient
                .get()
                .uri(url, productId)
                .retrieve()
                .bodyToMono(ProductInfo.class)
                .log();
    }

}