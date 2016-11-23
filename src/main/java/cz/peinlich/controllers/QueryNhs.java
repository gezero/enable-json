package cz.peinlich.controllers;

import cz.peinlich.dao.NhsPageInfo;
import cz.peinlich.dto.NhsResponse;
import cz.peinlich.services.JsonQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Jiri
 */
@RestController
public class QueryNhs {

    @Autowired
    JsonQueryService queryService;

    @RequestMapping("/search")
    public NhsResponse search(@RequestParam("query") String query) {
        Set<NhsPageInfo> nhsPageDetaiInfos = queryService.searchFor(query);
        List<String> results = new ArrayList<>(nhsPageDetaiInfos.size());
        for (NhsPageInfo nhsPageDeInfoInfo : nhsPageDetaiInfos) {
            results.add(nhsPageDeInfoInfo.getArticle_url());
        }
        return new NhsResponse(query, results);
    }

}
