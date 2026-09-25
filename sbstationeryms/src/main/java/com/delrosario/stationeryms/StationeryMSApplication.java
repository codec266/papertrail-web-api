package com.delrosario.stationeryms;

import com.delrosario.stationeryms.controller.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class StationeryMSApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(StationeryMSApplication.class, args);

    }
}
