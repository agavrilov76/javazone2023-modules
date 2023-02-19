package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.example.lib.StringUtils;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.printf("%n>>>%n%n");
    StringUtils.sayReversed("Hello!");
//     System.out.println(InternalStringUtils.reverse("LoL_"));

    System.out.printf("%n>>>%n%n");
    System.out.printf(
        "----------%n%s:%n%n%s%n", "resource1.txt", loadResource("data/resource1.txt"));
    System.out.printf(
        "----------%n%s:%n%n%s%n", "resource2.txt", loadResource("data-1/resource2.txt"));

    System.out.printf("%n>>>%n%s%n%n", parseJson());
  }

  static String loadResource(final String name) throws IOException {
    final var classLoader = Thread.currentThread().getContextClassLoader();

    final var resource =
        Objects.requireNonNull(
            classLoader.getResource(name), "Resource %s is not found".formatted(name));

    try (final var input = resource.openStream()) {
      return new String(input.readAllBytes(), StandardCharsets.UTF_8);
    }
  }

  static String parseJson() throws IOException {
    record Foo(String textField) {}
    final var foo = new Foo("Lorem ipsum dolor sit amet");
    final var objectMapper = new ObjectMapper().findAndRegisterModules();
    return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(foo);
  }
}
