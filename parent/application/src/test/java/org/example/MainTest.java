package org.example;

import java.io.IOException;
import org.example.lib.StringUtils;
import org.example.lib.internal.InternalStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void resource() throws IOException {
    Assertions.assertEquals(Main.loadResource("data/test.txt"), "test");
  }

  @Test
  void reverse() {
    Assertions.assertEquals(InternalStringUtils.reverse("abc"), "cba");
  }

  @Test
  void json() throws IOException {
    Assertions.assertEquals(
        """
        {
          "text_field" : "Lorem ipsum dolor sit amet"
        }""",
        Main.parseJson());
  }
}
