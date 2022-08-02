package com.config.database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "timetable.datasource")
@Data
public class DataSourceTimetableConfig {
    private String url;
    private String password;
    private String username;
}
