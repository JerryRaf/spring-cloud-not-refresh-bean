package com.github.loc.app.module;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Created on 2018/2/26.
 */
@Data
@ConfigurationProperties(prefix = "test")
public class InfoConfig {
  private String info;

}
