package org.example;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void resource() throws IOException {
    Assertions.assertEquals(Main.loadResource("data/test.txt"), "test");
    Assertions.assertEquals(
        Main.loadResource("data/resource1.txt"), "Lorem ipsum dolor sit amet\n");
  }

  /* @Test
  void reverse() {
    Assertions.assertEquals(InternalStringUtils.reverse("abc"), "cba");
  }*/

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
