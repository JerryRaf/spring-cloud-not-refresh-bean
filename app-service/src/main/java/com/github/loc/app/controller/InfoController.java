package com.github.loc.app.controller;

import com.github.loc.app.module.InfoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/2/26.
 */
@RefreshScope
@RestController
@EnableConfigurationProperties(InfoConfig.class)
public class InfoController {

  @Autowired
  private InfoConfig infoConfig;

  @Value("${test.value}")
  private String value;


  @GetMapping(value = "/info")
  public String info() {
    return infoConfig.getInfo();
  }

  @GetMapping(value = "/value")
  public String value() {
    return value;
  }

}
