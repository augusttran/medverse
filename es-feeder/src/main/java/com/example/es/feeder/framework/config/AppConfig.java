package com.example.es.feeder.framework.config;

import com.example.es.feeder.application.port.in.usecase.BulkFeedUseCase;
import com.example.es.feeder.application.port.in.usecase.FeedUseCase;
import com.example.es.feeder.domain.entity.CreateDocumentRequest;
import com.example.es.feeder.domain.entity.DrugDocument;
import com.example.es.feeder.framework.adapter.in.CsvFilesInputAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Configuration
@Slf4j
public class AppConfig {
    @Bean
    ApplicationRunner runner(CsvFilesInputAdapter inputAdapter, FeedUseCase feedUseCase, BulkFeedUseCase bulkFeedUseCase) {
        return ______ -> {
            var drugReader = Files.newBufferedReader(Path.of("C:\\Users\\Administrator\\Desktop\\drugbank_csv_backup",
            "drugbank05_drugs_general_info2412.csv"));

            var productReader = Files.newBufferedReader(Path.of("C:\\Users\\Administrator\\Desktop\\drugbank_csv_backup",
                "drugbank05_products_serial_2.csv"));

            var drugDocument = inputAdapter.adaptDrug(drugReader).stream();
            var productDocument = inputAdapter.adaptProduct(productReader).stream();

            Stream.concat(drugDocument, productDocument)
//                .limit(100)
                .forEach(feedUseCase::feed);

        };
    }
}
