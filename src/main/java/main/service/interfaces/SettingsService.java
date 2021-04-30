package main.service.interfaces;

import main.DTO.SettingsDTO;
import main.service.SettingsServiceImpl;

/**
 * PostService interface for {@link SettingsServiceImpl} class.
 */
public interface SettingsService {

    SettingsDTO getGlobalSettings();
}
