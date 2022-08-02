package com;

import com.config.datasource.DataSourceContextHolder;
import com.config.datasource.DataSourceEnum;
import com.domain.entity.Group;
import com.scheduler.Scheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class ReplicationDBApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReplicationDBApplication.class, args);
    }
}
