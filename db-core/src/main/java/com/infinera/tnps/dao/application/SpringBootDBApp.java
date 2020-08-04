package com.infinera.tnps.dao.application;

import com.infinera.tnps.common.messagehandler.*;
import com.infinera.tnps.dao.controller.DBController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackageClasses = DBController.class)
@EnableBinding({RequestReceiverChannel.class, ResponseSenderChannel.class, UploadFileRequestReceiverChannel.class})
@Configuration
@EnableAsync
@EntityScan("com.infinera.tnps")
@EnableJpaRepositories("com.infinera.tnps")
public class SpringBootDBApp {
    private static Logger LOG = LoggerFactory.getLogger(SpringBootDBApp.class);
    public static void main(String[] args) {
        LOG.info("SpringBootDBApp started !");
        SpringApplication.run(SpringBootDBApp.class, args);
    }
}

