package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ResourceLoader {
  public static void main(final String[] args) throws IOException {
    loadResource("data/resource1.txt");
    loadResource("data/resource2.txt");
  }

  private static void loadResource(final String name) throws IOException {
    final var classLoader = Thread.currentThread().getContextClassLoader();

    final var resource =
        Objects.requireNonNull(
            classLoader.getResource(name), "Resource %s is not found".formatted(name));

    try (final var input = resource.openStream()) {
      final var content = new String(input.readAllBytes(), StandardCharsets.UTF_8);
      System.out.printf("----------%n%s:%n%n%s%n", name, content);
    }

  }
}
