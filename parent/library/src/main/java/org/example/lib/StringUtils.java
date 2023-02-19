package org.example.lib;

import org.example.lib.internal.InternalStringUtils;

public final class StringUtils {

  private StringUtils() {}

  public static void sayReversed(final String word) {
    final var reversed = InternalStringUtils.reverse(word);
    System.out.printf("%s ===> %s%n", word, reversed);
  }
}
