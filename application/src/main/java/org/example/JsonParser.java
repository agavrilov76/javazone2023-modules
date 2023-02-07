package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JsonParser {
  record Foo(String textField) {}

  public static void main(String[] args) throws IOException {
    final var foo = new Foo("Lorem ipsum dolor sit amet");
    final var objectMapper = new ObjectMapper().findAndRegisterModules();
    final var json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(foo);
    System.out.println(json);
  }
}
