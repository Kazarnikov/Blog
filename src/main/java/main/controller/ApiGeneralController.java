package main.controller;

import lombok.extern.slf4j.Slf4j;
import main.DTO.SettingsDTO;
import main.api.response.CalendarResponse;
import main.api.response.InitResponse;
import main.api.response.StatisticsResponse;
import main.api.response.TagsResponse;
import main.service.PostServiceImpl;
import main.service.SettingsServiceImpl;
import main.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Прочий запросы к API.
 */
@Slf4j
@RestController
@RequestMapping(path = "/api")
public class ApiGeneralController {

    private final InitResponse initResponse;
    private final SettingsServiceImpl settingsService;
    private final TagServiceImpl tagService;
    private final PostServiceImpl postService;

    @Autowired
    public ApiGeneralController(InitResponse initResponse,
                                SettingsServiceImpl settingsService,
                                TagServiceImpl tagService,
                                PostServiceImpl postService) {

        this.initResponse = initResponse;
        this.settingsService = settingsService;
        this.tagService = tagService;
        this.postService = postService;
    }

    @GetMapping(value = "/settings")
    public SettingsDTO settings() {
        return settingsService.getGlobalSettings();
    }

    @GetMapping(value = "/init")
    public ResponseEntity<InitResponse> init() {
        return new ResponseEntity<>(initResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/tag")
    public ResponseEntity<TagsResponse> getTeg(
            @RequestParam(required = false) String query) {
        return new ResponseEntity<>(tagService.findTags(query), HttpStatus.OK);
    }

    @GetMapping(value = "/calendar")
    public ResponseEntity<CalendarResponse> getCalendar(
            @RequestParam(value = "year", required = false, defaultValue = "0") Integer year) {
        return new ResponseEntity<>(postService.numberPostsDate(year), HttpStatus.OK);
    }

    @GetMapping(value = "/statistics/all")
    public ResponseEntity<StatisticsResponse> getAllStatistics() {
        return new ResponseEntity<>(new StatisticsResponse(), HttpStatus.OK);
    }
}
