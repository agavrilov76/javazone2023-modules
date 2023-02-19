package org.example.lib.internal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InternalStringUtilsTest {

  @Test
  void reverse() {
    Assertions.assertEquals(InternalStringUtils.reverse("abc"), "cba");
  }
}
