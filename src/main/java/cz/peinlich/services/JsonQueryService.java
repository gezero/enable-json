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


    Set<NhsPageInfo> details = new HashSet<>();

    @PostConstruct
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

    private boolean acceptable(NhsPageInfo detail, String query) {
        return true;
    }
}
