import com.fasterxml.jackson.databind.Module;
import org.example.JacksonModule;

module org.example.application {
  requires org.example.library;
  requires com.fasterxml.jackson.databind;

  opens data;
  opens org.example to
      com.fasterxml.jackson.databind;

  provides Module with
      JacksonModule;
}
