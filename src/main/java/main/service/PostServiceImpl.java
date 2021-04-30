package main.service;


import main.DTO.PostCommentByIdDTO;
import main.DTO.PostDTO;
import main.DTO.PostUserByIdDTO;
import main.DTO.PostUserDTO;
import main.api.response.CalendarResponse;
import main.api.response.PostByIdResponse;
import main.api.response.PostsResponse;
import main.model.Post;
import main.model.PostComment;
import main.model.Tag;
import main.model.repository.PostCommentRepository;
import main.model.repository.PostRepository;
import main.model.repository.PostVoteRepository;
import main.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;
    private final PostVoteRepository postVoteRepository;
    private Page<Post> pagePost;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostCommentRepository postCommentRepository,
                           PostVoteRepository postVoteRepository) {
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
        this.postVoteRepository = postVoteRepository;
    }

    @Override
    @Transactional
    public PostsResponse findAllPost(int offset, int limit, String mode) {
        int page = offset / limit;
        pagePost = switch (mode) {
            case ("popular") -> postRepository.findAllByCommentPopular(PageRequest.of(page, limit));
            case ("best") -> postRepository.findAllByLikePopular(PageRequest.of(page, limit));
            case ("early") -> postRepository.findAll(PageRequest.of(page, limit, Sort.by("time").ascending()));
            default -> postRepository.findAll(PageRequest.of(page, limit, Sort.by("time").descending()));
        };
        return getPostsMainPage();
    }

    @Override
    @Transactional
    public PostsResponse findAllBySearch(int offset, int limit, String query) {
        int page = offset / limit;
        pagePost = postRepository.findAllBySearch(query, PageRequest.of(page, limit));
        return getPostsMainPage();
    }

    @Override
    @Transactional
    public PostsResponse findPostByDate(int offset, int limit, String date) {
        int page = offset / limit;
        pagePost = postRepository.findPostByDate(date, PageRequest.of(page, limit));
        return getPostsMainPage();
    }

    @Override
    @Transactional
    public PostsResponse findPostByTag(int offset, int limit, String tag) {
        int page = offset / limit;
        pagePost = postRepository.findAllByTag(tag, PageRequest.of(page, limit));
        return getPostsMainPage();
    }

    @Override
    @Transactional
    public PostByIdResponse findPostById(Long id) {
        return getPostByIdPage(id);
    }

    @Override
    public CalendarResponse numberPostsDate(Integer year) {
        CalendarResponse calendarResponse = new CalendarResponse();
        Map<LocalDate, Integer> mapDate = new HashMap<>();
        List<Post> postList = postRepository.numberPostsCalendar();

        int calendar;
        if (year == 0) {
            calendar = Calendar.getInstance().get(Calendar.YEAR);
        } else {
            calendar = year;
        }

        for (Post post : postList) {
            LocalDate date = post.getTime().toLocalDate();
            if (date.getYear() == calendar) {
                int count = mapDate.getOrDefault(date, 0);
                mapDate.put(date, count + 1);
            }
        }

        calendarResponse.setYears(postList.stream()
                .map(e -> e.getTime().getYear())
                .distinct()
                .collect(Collectors.toList()));
        calendarResponse.setPosts(mapDate);
        return calendarResponse;
    }


    private PostsResponse getPostsMainPage() {
        return new PostsResponse(
                pagePost.getTotalElements(),
                pagePost.getContent().stream().map(e ->
                        new PostDTO(
                                e.getId(),
                                e.getTime().toEpochSecond(ZoneOffset.UTC),
                                new PostUserDTO(e.getUserId().getId(), e.getUserId().getName()),
                                e.getTitle(),
                                e.getText().length() > 150 ? e.getText().substring(0, 150) + "..." : e.getText(),
                                postVoteRepository.countLikeById(e.getId()),
                                postVoteRepository.countDislikeById(e.getId()),
                                postCommentRepository.countAllById(e.getId()),
                                e.getViewCount()))
                        .collect(Collectors.toList()));
    }

    private PostByIdResponse getPostByIdPage(Long id) {
        Post post = postRepository.findPostById(id);
        postRepository.viewCount(id);

        if (post != null) {
            List<PostComment> listPostComment = postCommentRepository
                    .findAllByPostIdOrderByTimeDesc(post.getId());

            return new PostByIdResponse(
                    post.getId(),
                    post.getTime().toEpochSecond(ZoneOffset.UTC),
                    true,
                    new PostUserDTO(
                            post.getUserId().getId(),
                            post.getUserId().getName()),
                    post.getTitle(),
                    post.getText(),
                    postVoteRepository.countLikeById(post.getId()),
                    postVoteRepository.countDislikeById(post.getId()),
                    post.getViewCount(),
                    listPostComment.stream().map(e -> new PostCommentByIdDTO(
                            e.getId(),
                            e.getTime().toEpochSecond(ZoneOffset.UTC),
                            e.getText(),
                            new PostUserByIdDTO(
                                    e.getUserId().getId(),
                                    e.getUserId().getName(),
                                    e.getUserId().getPhoto())))
                            .collect(Collectors.toList()),
                    post.getTagsList().stream().map(Tag::getName).collect(Collectors.toList())
            );
        } else {
            return new PostByIdResponse();
        }

    }


//    public PostDTO mapPost(Post post) {
//        return postMapper.toDto(post);
//    }

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
