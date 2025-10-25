package org.carpenoctemcloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.carpenoctemcloud.configuration.ConfigurationConstants.MAX_FETCH_SIZE;

@Controller
public class searchPageController {

    @GetMapping({"/search", "/search/"})
    public String searchPage(Model model, @RequestParam(required = false) String query,
                             @RequestParam(required = false) Integer offset) {
        if (offset != null) {
            offset = (offset > 0) ? offset : 0;
        }

        query = (query != null) ? query : "";
        offset = (offset != null) ? offset : 0;

        model.addAttribute("query", query);
        model.addAttribute("offset", offset);
        model.addAttribute("maxFetchSize", MAX_FETCH_SIZE);

        return "searchPage";
    }
}