package com.example.es.feeder.framework.adapter.in;

import com.example.es.feeder.application.port.in.FeedInputPort;
import com.example.es.feeder.domain.entity.CreateDocumentRequest;
import com.example.es.feeder.domain.factory.EntityFactory;
import com.example.es.feeder.domain.entity.DrugDocument;
import com.example.es.feeder.domain.entity.ProductDocument;
import com.example.es.feeder.framework.dto.DrugDto;
import com.example.es.feeder.framework.dto.ProductDto;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
@Component
public class CsvFilesInputAdapter {
    private final FeedInputPort feedInputPort;
    private final EntityFactory<DrugDto, CreateDocumentRequest<DrugDocument>> drugDocumentRequestFactory;
    private final EntityFactory<ProductDto, CreateDocumentRequest<ProductDocument>> productDocumentRequestFactory;

    public List<CreateDocumentRequest<DrugDocument>> adaptDrug(Reader reader) throws IOException, CsvException {
        log.info("Preparing adaptDrug !");
        CSVReader csvReader = new CSVReader(reader);
        var all = csvReader.readAll();
        var fieldMapper = new FieldMapper(all.get(0));
        var allValues = all.subList(1, all.size());

        Function<String[], DrugDto> drugDtoConverter = stringArr -> {
            String id = stringArr[fieldMapper.getPosition("drugbank_id")];
            String name = stringArr[fieldMapper.getPosition("drug_name")];
            String indication = stringArr[fieldMapper.getPosition("drug_indication")];
            String mechanism = stringArr[fieldMapper.getPosition("drug_mechanism_of_action")];
            String pharmacodynamics = stringArr[fieldMapper.getPosition("drug_pharmacodynamics")];
            return DrugDto.builder()
                .id(id)
                .name(name)
                .pharmacodynamics(pharmacodynamics)
                .indication(indication)
                .mechanism(mechanism)
                .build();
        };
        List<CreateDocumentRequest<DrugDocument>> drugDocument = allValues.stream()
            .map(drugDtoConverter)
            .map(drugDocumentRequestFactory::from)
            .toList();

        log.info("Done adaptDrug !");

        return drugDocument;
    }

    public List<CreateDocumentRequest<ProductDocument>> adaptProduct(Reader reader) throws IOException, CsvException {
        log.info("Preparing adaptProduct !");
        CSVReader csvReader = new CSVReader(reader);
        var all = csvReader.readAll();
        var fieldMapper = new FieldMapper(all.get(0));
        var allValues = all.subList(1, all.size());

        Function<String[], ProductDto> productDtoConverter = stringArr -> {
            String id = stringArr[fieldMapper.getPosition("product_id_")];
            String name = stringArr[fieldMapper.getPosition("product_name")];
            String labeller = stringArr[fieldMapper.getPosition("product_labeller")];
            return ProductDto.builder()
                .id(id)
                .name(name)
                .labeller(labeller)
                .build();
        };

        List<CreateDocumentRequest<ProductDocument>> productDocument = allValues.stream()
            .map(productDtoConverter)
            .map(productDocumentRequestFactory::from)
            .toList();

        log.info("Done adaptProduct !");

        return productDocument;
    }

    @ToString
    private static class FieldMapper {
        private final Map<String, Integer> positionMap = new HashMap<>();

        private FieldMapper(String[] fieldNames) {
            IntStream.range(0, fieldNames.length).forEach(i -> {
                positionMap.put(fieldNames[i].trim(), i);
            });
        }

        public int getPosition(String fieldName) {
            return positionMap.getOrDefault(fieldName, -1);
        }
    }
}
