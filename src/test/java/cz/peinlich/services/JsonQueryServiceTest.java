package cz.peinlich.services;

import cz.peinlich.dao.NhsPageInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Jiri
 */
public class JsonQueryServiceTest {

    private JsonQueryService service;

    @Before
    public void acceptable() throws Exception {
        service = new JsonQueryService();
        service.details = new HashSet<>(Arrays.asList(
                new NhsPageInfo("host", "section", "section_url", "1", "article_url", "Hello"),
                new NhsPageInfo("host", "section", "section_url", "2", "article_url", "Hello world")));

    }


    @Test
    public void testAcceptable() throws Exception {
        boolean acceptable = service.acceptable(new NhsPageInfo("host", "section", "section_url", "1", "article_url", "Hello"), "Hello");
        assertThat(acceptable, is(true));
    }
    @Test
    public void testNotAcceptable() throws Exception {
        boolean acceptable = service.acceptable(new NhsPageInfo("host", "section", "section_url", "1", "article_url", "Hello"), "World");
        assertThat(acceptable, is(false));
    }

    @Test
    public void testLostWords() throws Exception {
        boolean acceptable = service.acceptable(new NhsPageInfo("host", "section", "section_url", "1", "article_url", "Hello"), "What are the Hello for");
        assertThat(acceptable, is(true));
    }
}