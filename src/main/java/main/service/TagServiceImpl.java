package main.service;

import lombok.extern.slf4j.Slf4j;
import main.DTO.TagDTO;
import main.DTO.interfaces.TagAnswerStatistics;
import main.api.response.TagsResponse;
import main.model.repository.TagRepository;
import main.service.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    @Transactional
    public TagsResponse findTags(String query) {

        List<TagAnswerStatistics> collect;

        if (query == null || query.equals("")) {
            collect = tagRepository.findTags();
        } else {
            collect = tagRepository.findByTag(query);
        }

        if (collect.isEmpty()) {
            return new TagsResponse();
        } else {
            double weights = collect.size();
            double maxCount = collect.iterator().next().getCount();
            double k = 1.0 / (maxCount / weights);

            return new TagsResponse(collect.stream()
                    .map(e -> new TagDTO(e.getName(), getWeight(weights, e.getCount(), k)))
                    .collect(Collectors.toList()));
        }
    }

    private double getWeight(double weights, double tagCount, double k) {
        double weight = (tagCount / weights) * k;
        return Math.min(1, Math.max(weight, 0.30));
    }
}