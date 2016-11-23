package cz.peinlich.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.peinlich.dao.NhsPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiri
 */
@Service
public class JsonQueryService {

    @Value("${json.location}")
    String jsonLocation;

    @Autowired
    private ResourceLoader resourceLoader;

    Set<String> ignoredWords = new HashSet<>(Arrays.asList("What", "are", "the", "of", "for"));


    Set<NhsPageInfo> details = new HashSet<>();

    @PostConstructx
    public void loadJson() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Resource resource = resourceLoader.getResource("classpath:" + jsonLocation);
        MappingIterator<NhsPageInfo> objectMappingIterator = jsonMapper.readerFor(NhsPageInfo.class).readValues(resource.getFile());

        while (objectMappingIterator.hasNext()) {
            NhsPageInfo next = objectMappingIterator.next();
            details.add(next);
        }
    }

    public Set<NhsPageInfo> searchFor(String query) {
        Set<NhsPageInfo> result = new HashSet<>();
        for (NhsPageInfo detail : details) {
            if (acceptable(detail,query)){
                result.add(detail);
            }
        }
        return result;
    }


    /**
     *  This is search is very simple we just check that each word from query is somewhere in the content.
     *  We skip the ignored words
     */
    private boolean acceptable(NhsPageInfo detail, String query) {
        if (query == null){
            return false;
        }
        String[] split = query.split("\\s+");
        boolean queried =false;
        for (String s : split) {
            if (ignoredWords.contains(s)){
                continue;
            }
            queried = true;
            if (!detail.getContent().contains(s)){
                return false;
            }
        }
        return queried;
    }
}
