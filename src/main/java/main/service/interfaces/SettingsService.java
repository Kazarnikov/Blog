package main.service.interfaces;

import main.api.response.SettingsResponse;
import main.service.SettingsServiceImpl;

/**
 * PostService interface for {@link SettingsServiceImpl} class.
 */
public interface SettingsService {
    SettingsResponse getGlobalSettings();
}
