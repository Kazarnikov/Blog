package main.service;

import main.DTO.SettingsDTO;
import main.model.GlobalSetting;
import main.model.repository.GlobalSettingRepository;
import main.service.interfaces.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SettingsServiceImpl implements SettingsService {

    private final GlobalSettingRepository globalSettingRepository;
    private final SettingsDTO settingsDTO;

    @Autowired
    public SettingsServiceImpl(GlobalSettingRepository globalSettingRepository,
                               SettingsDTO settingsDTO) {
        this.globalSettingRepository = globalSettingRepository;
        this.settingsDTO = settingsDTO;
    }

    @Override
    @Transactional
    public SettingsDTO getGlobalSettings() {

        Iterable<GlobalSetting> globalSettings = globalSettingRepository.findAll();

        for (GlobalSetting setting : globalSettings) {
            String code = setting.getCode();
            String value = setting.getValue().trim();
            switch (code) {
                case "MULTIUSER_MODE" -> settingsDTO.setMultiuserMode(getBoolean(value));
                case "POST_PREMODERATION" -> settingsDTO.setPostPremoderation(getBoolean(value));
                case "STATISTICS_IS_PUBLIC" -> settingsDTO.setStatisticsIsPublic(getBoolean(value));
            }
        }
        return settingsDTO;
    }

    /**
     * If the value is YES - return true, if NO - return false
     */
    public boolean getBoolean(String setting) {
        return setting.equals("YES");
    }
}
