package main.service;

import main.api.response.SettingsResponse;
import main.service.interfaces.SettingsService;
import org.springframework.stereotype.Service;

@Service
public class SettingsServiceImpl implements SettingsService {
    @Override
    public SettingsResponse getGlobalSettings() {
        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setMultiuserMode(true);
        settingsResponse.setStatisticsIsPublic(true);
        return settingsResponse;
    }

}
