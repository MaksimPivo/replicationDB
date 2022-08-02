package com.config.datasource;

import com.config.database.DataSourceElectronicJournalConfig;
import com.config.database.DataSourceStudentAccountConfig;
import com.config.database.DataSourceTimetableConfig;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSourceRouting extends AbstractRoutingDataSource {
    private DataSourceElectronicJournalConfig dataSourceElectronicJournalConfig;
    private DataSourceStudentAccountConfig dataSourceStudentAccountConfig;
    private DataSourceTimetableConfig dataSourceTimetableConfig;
    private DataSourceContextHolder dataSourceContextHolder;

    public DataSourceRouting(DataSourceContextHolder dataSourceContextHolder, DataSourceElectronicJournalConfig dataSourceElectronicJournalConfig, DataSourceStudentAccountConfig dataSourceStudentAccountConfig,
                             DataSourceTimetableConfig dataSourceTimetableConfig) {
        this.dataSourceElectronicJournalConfig = dataSourceElectronicJournalConfig;
        this.dataSourceStudentAccountConfig = dataSourceStudentAccountConfig;
        this.dataSourceTimetableConfig = dataSourceTimetableConfig;
        this.dataSourceContextHolder = dataSourceContextHolder;

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.ELECTRONIC_JOURNAL, dataSourceElectronicJournal());
        dataSourceMap.put(DataSourceEnum.STUDENT_ACCOUNT, dataSourceStudentAccount());
        dataSourceMap.put(DataSourceEnum.TIMETABLE, dataSourceTimetable());
        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(dataSourceStudentAccount());
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContextHolder.getBranchContext();
    }

    public DataSource dataSourceStudentAccount() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceStudentAccountConfig.getUrl());
        dataSource.setUsername(dataSourceStudentAccountConfig.getUsername());
        dataSource.setPassword(dataSourceStudentAccountConfig.getPassword());
        return dataSource;
    }

    public DataSource dataSourceTimetable() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceTimetableConfig.getUrl());
        dataSource.setUsername(dataSourceTimetableConfig.getUsername());
        dataSource.setPassword(dataSourceTimetableConfig.getPassword());
        return dataSource;
    }

    public DataSource dataSourceElectronicJournal() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceElectronicJournalConfig.getUrl());
        dataSource.setUsername(dataSourceElectronicJournalConfig.getUsername());
        dataSource.setPassword(dataSourceElectronicJournalConfig.getPassword());
        return dataSource;
    }
}
