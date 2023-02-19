package org.example;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JacksonModule extends SimpleModule {

  @Override
  public void setupModule(final SetupContext context) {
    context.setNamingStrategy(SnakeCaseStrategy.INSTANCE);
  }
}
