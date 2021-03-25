package main.controller;

import main.api.response.InitResponse;
import main.api.response.SettingsResponse;
import main.repository.GlobalSettingRepository;
import main.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Прочий запросы к API.
 */
@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    @Autowired
    private GlobalSettingRepository globalSettingRepository;

    private final InitResponse initResponse;
    private final SettingsService settingsService;

    public ApiGeneralController(InitResponse initResponse, SettingsService settingsService) {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
    }

    @GetMapping(value = "/settings")
    private SettingsResponse settings() {
        return settingsService.getGlobalSettings();


    }

    @GetMapping(value = "/init", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    private InitResponse init() {
        return initResponse;
    }
}
