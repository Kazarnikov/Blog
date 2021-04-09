package main.service;


import lombok.extern.slf4j.Slf4j;
import main.DTO.PostDTO;
import main.DTO.UserDTO;
import main.DTO.interfaces.PostAnswer;
import main.api.response.PostResponse;
import main.model.repository.PostCommentRepository;
import main.model.repository.PostRepository;
import main.service.interfaces.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;
    private PostResponse postResponse;
    private Page<PostAnswer> pagePost;

    public PostServiceImpl(PostRepository postRepository, PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
    }


    @Override
    public PostResponse findAllPost(int offset, int limit, String mode) {
        pagePost = postRepository.findAllPost(getPageableSort(offset, limit, mode));
        getPostsStream(pagePost.getContent());
        return postResponse;
    }

    public void getPostsStream(List<PostAnswer> posts) {
        postResponse = new PostResponse();
        postResponse.setCount(posts.size());

        postResponse.setPosts(posts.stream().map(e -> new PostDTO(
                e.getId(),
                e.getTimestamp().toEpochSecond(ZoneOffset.UTC),
                new UserDTO(e.getUserId(), e.getUserName()),
                e.getTitle(),
                e.getAnnounce(),
                e.getLikeCount(),
                e.getDislikeCount(),
                postCommentRepository.findAllById(e.getId()),
                e.getViewCount()))
                .collect(Collectors.toList()));
    }

    public Pageable getPageableSort(int offset, int limit, String mode) {
        int page = offset / limit;
        Sort sort = switch (mode) {
            case ("popular") -> Sort.by("commentCount").descending();
            case ("best") -> Sort.by("likeCount").descending();
            case ("early") -> Sort.by("timestamp").ascending();
            default -> Sort.by("timestamp").descending();
        };
        return PageRequest.of(page, limit, sort);
    }

//    @Override
//    public PostResponse findByTag(Pageable pageable, String tag) {
//        return null;
//    }
//
//    @Override
//    public List<Post> findSearch(String s) {
//        return null;
//    }
//
//    @Override
//    public List<Post> findByDate(Date date) {
//        return null;
//    }
//
//    @Override
//    public List<Post> findByTag(String tag) {
//        return null;
//    }
//
//    @Override
//    public Post findById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public List<Post> findByModeration(ModerationStatus status) {
//        return null;
//    }
//
//    @Override
//    public List<Post> findByMyId(Integer id) {
//        return null;
//    }
//
//    @Override
//    public void save(Integer id) {
//
//    }
//
//    @Override
//    public void like(Integer id) {
//
//    }
//
//    @Override
//    public void dislike(Integer id) {
//
//    }
//
//    @Override
//    public void editByID(Integer id) {
//
//    }
}
