package main.controller;

import lombok.extern.slf4j.Slf4j;
import main.api.response.PostByIdResponse;
import main.api.response.PostsResponse;
import main.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Обрабатывает все запросы /api/post/*
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/post")
public class ApiPostController {

    private final PostServiceImpl postService;

    @Autowired
    public ApiPostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping(value = "")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<PostsResponse> getPosts(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "mode", defaultValue = "recent") String mode) {
        return new ResponseEntity<>(postService.findAllPost(offset, limit, mode), HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<PostsResponse> getPostsBySearch(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "query") String query) {
        return new ResponseEntity<>(postService.findAllBySearch(offset, limit, query.trim()), HttpStatus.OK);
    }

    @GetMapping(value = "/byDate")
    public ResponseEntity<PostsResponse> getPostsByDate(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "date") String date) {
        return new ResponseEntity<>(postService.findPostByDate(offset, limit, date), HttpStatus.OK);
    }

    @GetMapping(value = "/byTag")
    public ResponseEntity<PostsResponse> getPostsByTag(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "tag") String tag) {
        return new ResponseEntity<>(postService.findPostByTag(offset, limit, tag), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostByIdResponse> getPostById(
            @PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/moderation")
    public ResponseEntity getPostsForModeration() {
        log.info("\u001B[31mIN getPostsForModeration\u001B[0m");
        return null;
    }

    @GetMapping(value = "/my")
    public ResponseEntity getMyPosts() {
        log.info("\u001B[31mIN getMyPosts\u001B[0m");
        return null;
    }

}
