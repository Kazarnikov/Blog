package main.service;

import lombok.extern.slf4j.Slf4j;
import main.DTO.TagDTO;
import main.DTO.interfaces.TagAnswerStatistics;
import main.api.response.TagResponse;
import main.model.repository.PostRepository;
import main.model.repository.TagRepository;
import main.service.interfaces.TagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final PostRepository postRepository;
    private TagResponse tagResponse;

    public TagServiceImpl(TagRepository tagRepository, PostRepository postRepository) {
        this.tagRepository = tagRepository;
        this.postRepository = postRepository;
    }

    @Override
    public TagResponse findTags(String query) {
        tagResponse = new TagResponse();
        List<TagAnswerStatistics> collect;

        if (query == null || query.equals("")) {
            collect = tagRepository.findTags();
        } else {
            collect = tagRepository.findByTag(query);
        }

        if (collect.isEmpty()) {
            return new TagResponse();
        } else {
            double weights = postRepository.findByActiveStatus().size();
            double maxCount = collect.iterator().next().getCount();
            double k = 1.0 / (maxCount / weights);

            tagResponse.setTags(collect.stream()
                    .map(e -> new TagDTO(e.getName(), getWeight(weights, e.getCount(), k)))
                    .collect(Collectors.toList()));
        }
        return tagResponse;
    }

    private double getWeight(double weights, double tagCount, double k) {
        double weight = (tagCount / weights) * k;
        return Math.min(1, Math.max(weight, 0.30));
    }
}