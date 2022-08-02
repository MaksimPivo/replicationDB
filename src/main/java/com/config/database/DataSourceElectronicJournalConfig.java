package com.config.database;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "electronicjournal.datasource")
@Data
public class DataSourceElectronicJournalConfig {
    private String url;
    private String password;
    private String username;
}
