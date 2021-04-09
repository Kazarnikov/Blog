package main.controller;

import lombok.extern.slf4j.Slf4j;
import main.api.response.InitResponse;
import main.api.response.SettingsResponse;
import main.api.response.TagResponse;
import main.service.SettingsServiceImpl;
import main.service.TagServiceImpl;
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

    public ApiGeneralController(InitResponse initResponse,
                                SettingsServiceImpl settingsService,
                                TagServiceImpl tagService) {

        this.initResponse = initResponse;
        this.settingsService = settingsService;
        this.tagService = tagService;
    }

    @GetMapping(value = "/settings")
    private SettingsResponse settings() {
        return settingsService.getGlobalSettings();
    }

    @GetMapping(value = "/init")
    private ResponseEntity<InitResponse> init() {
        return new ResponseEntity<>(initResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/tag")
    public ResponseEntity<TagResponse> getTeg(@RequestParam(required = false) String query) {
        log.info("IN getTeg - query: {}", query);
        return new ResponseEntity<>(tagService.findTags(query), HttpStatus.OK);
    }
}
