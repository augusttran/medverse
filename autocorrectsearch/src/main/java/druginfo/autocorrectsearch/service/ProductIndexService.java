package druginfo.autocorrectsearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import druginfo.autocorrectsearch.model.Product;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WrapperQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class ProductIndexService {

    @Autowired
    private RestHighLevelClient elasticStackclient;

    @Value("${products-index-name}")
    private String productIndexName;

    @Value("${products-index-highlighted-fields}")
    private String productIndexNameFinderHighlightedFields;

    public List<Product> queryDescriptionSearchAsYouType(String searchValue) throws IOException {

        List<Product> menuItemList = new ArrayList<>();
        SearchRequest searchRequest2 = new SearchRequest(productIndexName);

        String descriptionSearchAsYouTypeQuery = "{\r\n"
                + "    \"multi_match\": {\r\n"
                + "      \"query\": \"" + searchValue + "\",\r\n"
                + "      \"type\": \"bool_prefix\",\r\n"
                + "      \"fields\": [\r\n"
                + "        \"name.shingles\",\r\n"
                + "        \"name.shingles._3gram\",\r\n"
                + "        \"name.shingles._4gram\",\r\n"
                + "        \"name.shingles._index_prefix\",\r\n"
                + "        \"name.ngrams\"\r\n"
                + "      ]\r\n"
                + "    }\r\n"
                + "  },\r\n"
                + "  \"highlight\" : {\r\n"
                + "    \"fields\" : [\r\n"
                + "      {\r\n"
                + "        \"name.ngrams\": { } \r\n"
                + "      }\r\n"
                + "    ]\r\n"
                + "  }";


        WrapperQueryBuilder qb = QueryBuilders.wrapperQuery(descriptionSearchAsYouTypeQuery);

        // add source builder.
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(qb);
        // can be used for pagination.
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // add highlighter to search query.
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field highlightTitle = new HighlightBuilder.Field(productIndexNameFinderHighlightedFields);
        highlightTitle.highlighterType("unified");
        highlightBuilder.field(highlightTitle);

        sourceBuilder.highlighter(highlightBuilder);

        searchRequest2.source(sourceBuilder);

        String highlighted = "";
        SearchResponse searchResponse = elasticStackclient.search(searchRequest2, RequestOptions.DEFAULT);
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            Product menuItem = new ObjectMapper().readValue(searchHit.getSourceAsString(), Product.class);
            menuItem.setProductID(searchHit.getId());
            menuItem.setHitScore(searchHit.getScore());

            if (!Objects.isNull(searchHit.getHighlightFields().get(productIndexNameFinderHighlightedFields))) {

                // get highlighted fields.
                if (!Objects
                        .isNull(((HighlightField) searchHit.getHighlightFields().get(productIndexNameFinderHighlightedFields))
                                .getFragments())) {
                    highlighted = ((HighlightField) searchHit.getHighlightFields().get(productIndexNameFinderHighlightedFields))
                            .getFragments()[0].string();
                }
            }
            menuItemList.add(menuItem);
        }

        return menuItemList;
    }

}
