package com.github.loc.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created on 2018/2/26.
 */
@SpringBootApplication
@EnableConfigServer
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
