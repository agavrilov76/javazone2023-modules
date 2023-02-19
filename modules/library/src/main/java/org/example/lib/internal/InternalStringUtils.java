package org.example.lib.internal;

public final class InternalStringUtils {

  private InternalStringUtils() {}

  public static String reverse(final String word) {
    return new StringBuilder(word).reverse().toString();
  }
}
