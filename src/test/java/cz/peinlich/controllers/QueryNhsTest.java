package cz.peinlich.controllers;

import cz.peinlich.dao.NhsPageInfo;
import cz.peinlich.services.JsonQueryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.HashSet;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Jiri
 */
public class QueryNhsTest {
    public static final HashSet<NhsPageInfo> FOUND = new HashSet<>((Collections.singletonList(new NhsPageInfo("host", null, null, null, "article_url", null))));
    @InjectMocks
    QueryNhs controller;
    MockMvc mockMvc;

    @Mock
    JsonQueryService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testRestCall() throws Exception {


        when(service.searchFor("random_query")).thenReturn(FOUND);

        mockMvc.perform(get("/search?query=random_query"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.query", is("random_query")));
    }
}