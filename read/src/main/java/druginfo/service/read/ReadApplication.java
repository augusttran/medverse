package druginfo.service.read;

import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@EnableCaching
@EnableEurekaClient
@SpringBootApplication
@Slf4j
@EnableZuulProxy
@ComponentScan({ "druginfo.service.read" })
@EntityScan("druginfo.service.read.model")
@EnableR2dbcRepositories("druginfo.service.read.repository")
public class ReadApplication {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(ReadApplication.class, args);
    }

    @RestController
    class ServiceInstanceRestController {

        @Autowired
        private DiscoveryClient discoveryClient;

        @RequestMapping("/service-instances/{applicationName}")
        public List<ServiceInstance> serviceInstancesByApplicationName(
                @PathVariable String applicationName) {
            return this.discoveryClient.getInstances(applicationName);
        }
    }
}
