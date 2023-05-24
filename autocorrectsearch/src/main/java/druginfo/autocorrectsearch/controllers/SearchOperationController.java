package druginfo.autocorrectsearch.controllers;

import druginfo.autocorrectsearch.model.Product;
import druginfo.autocorrectsearch.service.ProductIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/search2")
@CrossOrigin
public class SearchOperationController {

    @Autowired
    private ProductIndexService productIndexService;

    @GetMapping("/t")
    @ResponseBody
    public String home() {
        return "API search 2 works!";
    }

    @GetMapping("/name/{searchValue}")
    public ResponseEntity<List<Product>> getMenuItemByDescription(@PathVariable String searchValue) throws IOException {
        if(!StringUtils.hasText(searchValue)) {
            new ResponseEntity<>(new ArrayList<Product>(), HttpStatus.NOT_FOUND);
        }
        else if(searchValue.length() < 3) {
            new ResponseEntity<>(new ArrayList<Product>(), HttpStatus.NOT_FOUND);
        }
        else {

        }
        return new ResponseEntity<>(productIndexService.queryDescriptionSearchAsYouType(searchValue), HttpStatus.OK);
    }
}
