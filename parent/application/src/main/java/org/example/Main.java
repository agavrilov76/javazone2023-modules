package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.example.lib.StringUtils;
import org.example.lib.internal.InternalStringUtils;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.printf("%n>>>%n%n");
    StringUtils.sayReversed("Hello!");
    System.out.println(InternalStringUtils.reverse("LoL_"));

    System.out.printf("%n>>>%n%n");
    loadResource("data/resource1.txt");
    loadResource("data/resource2.txt");

    System.out.printf("%n>>>%n%n");
    parseJson();
  }

  static void loadResource(final String name) throws IOException {
    final var classLoader = Thread.currentThread().getContextClassLoader();

    final var resource =
        Objects.requireNonNull(
            classLoader.getResource(name), "Resource %s is not found".formatted(name));

    try (final var input = resource.openStream()) {
      final var content = new String(input.readAllBytes(), StandardCharsets.UTF_8);
      System.out.printf("----------%n%s:%n%n%s%n", name, content);
    }
  }

  static void parseJson() throws IOException {
    record Foo(String textField) {}
    final var foo = new Foo("Lorem ipsum dolor sit amet");
    final var objectMapper = new ObjectMapper().findAndRegisterModules();
    final var json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(foo);
    System.out.println(json);
  }
}
