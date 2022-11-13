package secretjuju.gaemihouse.keyword.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.keyword.dto.KeywordDTO;
import secretjuju.gaemihouse.keyword.model.Keyword;
import secretjuju.gaemihouse.keyword.repository.KeywordRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class KeywordService {

    private final KeywordRepository keywordRepository;
    private final ModelMapper modelMapper;

    public KeywordService(KeywordRepository keywordRepository, ModelMapper modelMapper) {
        this.keywordRepository = keywordRepository;
        this.modelMapper = modelMapper;
    }

    public List<KeywordDTO> findAllByKeywordDateBetween(Date start, Date end) {
        List<Keyword> keywords = keywordRepository.findAllByKeywordDateBetweenOrderByKeywordCountDesc(start, end);
        List<KeywordDTO> keywordDTOS = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            keywordDTOS.add(modelMapper.map(keywords.get(i), KeywordDTO.class));
        }

        return keywordDTOS;
    }
}
