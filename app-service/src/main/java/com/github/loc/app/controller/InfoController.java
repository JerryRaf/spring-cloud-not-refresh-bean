package com.github.loc.app.controller;

import com.github.loc.app.module.BinderConfig;
import com.github.loc.app.module.InfoConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/2/26.
 */
@Slf4j
@RefreshScope
@RestController
@EnableConfigurationProperties(InfoConfig.class)
public class InfoController {

  @Autowired
  private ConfigurableEnvironment environment;

  @Autowired
  private InfoConfig infoConfig;


  @GetMapping(value = "/info")
  public String info() {
    return infoConfig.getInfo();
  }

  @GetMapping(value = "/binder")
  public String binder() {
    BinderConfig binderConfig = resolverSetting(BinderConfig.class, "binder", environment, "binder");
    log.info(binderConfig.toString());
    return "ok";
  }

  public static <T> T resolverSetting(Class<T> clazz, String targetName,
      ConfigurableEnvironment environment,
      String propertiesName) {
    try {
      return new Binder(ConfigurationPropertySources.from(environment.getPropertySources()))
          .bind(targetName, Bindable.of(clazz))
          .orElseThrow(
              () -> new FatalBeanException("Could not bind DataSourceSettings properties"));
    } catch (Exception e) {
      //ignore
      throw new FatalBeanException("Could not bind" + propertiesName + " properties", e);
    }
  }

}
