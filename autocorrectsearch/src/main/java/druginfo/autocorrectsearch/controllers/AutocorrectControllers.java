package druginfo.autocorrectsearch.controllers;

import druginfo.autocorrectsearch.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class AutocorrectControllers {

    @GetMapping
    public String home(){
        return "Autocorrect home";
    }

    @RequestMapping(value = "/suggestion", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SuggestionWrapper autocompleteSuggestions(@RequestParam("searchstr") String searchstr) {
        System.out.println("searchstr: " + searchstr);

        ArrayList<Product> suggestions = new ArrayList<>();

        int n = suggestions.size() > 20 ? 20 : suggestions.size();
        List<Product> sulb = new ArrayList<>(suggestions.subList(0, n));

        SuggestionWrapper sw = new SuggestionWrapper();
        sw.setSuggestions(sulb);
        return sw;
    }
}
