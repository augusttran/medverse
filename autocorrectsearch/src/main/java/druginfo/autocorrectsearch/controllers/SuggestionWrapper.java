package druginfo.autocorrectsearch.controllers;

import druginfo.autocorrectsearch.model.Product;

import java.util.List;


public class SuggestionWrapper {

    List<Product> suggestions;

    public List<Product> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Product> suggestions) {
        this.suggestions = suggestions;
    }
}