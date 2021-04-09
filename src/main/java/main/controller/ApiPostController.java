package main.controller;

import lombok.extern.slf4j.Slf4j;
import main.api.response.PostResponse;
import main.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Обрабатывает все запросы /api/post/*
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/post")
public class ApiPostController {

    @Autowired
    private PostServiceImpl postService;

    @GetMapping(value = "")
    public ResponseEntity<PostResponse> getPost(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "mode", defaultValue = "recent") String mode) {
        log.info("IN getPost - mode: {}, offset: {}", mode, offset );
        return new ResponseEntity<>(postService.findAllPost(offset, limit, mode), HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    private ResponseEntity getSearch() {
        log.info("IN getSearch");
        return null;
    }

    @GetMapping(value = "/byDate")
    private ResponseEntity getByDate() {
        log.info("IN getByDate");
        return null;
    }

    @GetMapping(value = "/byTag")
    private ResponseEntity getByTag() {
        log.info("IN getByTag");
        return null;
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity getById() {
        log.info("IN getById");
        return null;
    }

    @GetMapping(value = "/moderation")
    private ResponseEntity getModeration() {
        log.info("IN getModeration");
        return null;
    }

    @GetMapping(value = "/my")
    private ResponseEntity getByMy() {
        log.info("IN getByMy");
        return null;
    }

}
