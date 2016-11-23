package cz.peinlich.controllers;

import cz.peinlich.dto.NhsResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Jiri
 */
@RestController
public class QueryNhs {

    @RequestMapping("/search")
    public NhsResponse search(@RequestParam("query") String query){
        return new NhsResponse(query, Arrays.asList("http://google.com"));
    }

}
