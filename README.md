# Practical experience of using Java Modules

20 min

# Abstract

Java Modules is one of the most prominent Java platform features introduced in Java 9. It provides a
number of good benefits despite slow adoption by the Java developers. Using modules gives a better
control over third-party dependencies, clean and logical code structure and ability to create custom
application-specific Java runtime(s).

In this talk I will show by example how to build and run a modular java application.

Starting with Java Modules is as simple as adding a module-info.java file to the source path. The
modern IDEs and build tools will automatically recognize it and help out to get started. Only
classes from the required modules will be visible for the application at compile time. Only specific
modules can access the application classes via reflection at runtime time.

What is the difference between class-path and module-path? Do you need to declare module info for
tests? How does resource loading work across different modules? How to package and containerize a
modular application? Join me on my talk if you want to know!

# Touch points

- A brief history of Java Platform Module System (JPMS)
- Discuss JPMS design goals:
    - Explicit declaration of dependencies between modules at compile time and runtime time
    - Strong encapsulation for the Java platform and applications
    - Scalable modular Java platform
    - Improved performance
    - Backwards compatibility
- Consider a sample Java project consisted of an application and a library. The app can read
  text resource files and parse JSON
- Add a `module-info` to the library, then to the application, set the module name, add
  the `requires` and `exports` sections
- Discuss readability and visibility
- Fix the package split issue in the library code
- Open reflection module access to Jackson
- Add `uses` to get the custom Jackson module to become visible
- Fix the resource loading issue
- Discuss the difference between encapsulated and not-encapsulated resources
- Run tests and note the difference between `module-path` and `class-path`
- Build a bundle with the maven assembly plugin, show how to run the app using the `module-path`
- Create an executable distribution using `jlink`
- Create a Docker container and run it
- Some things to be aware of:
    - Use the latest version of tooling
    - Encapsulation rules are difficult
    - Unit and integration test coverage is important
    - Auto-modules don't work `jlink`
- Q/A

# Talk structure

- Start the talk with a few slides covering two first points above
- Switch to demo mode using the IntelliJ IDEA community edition and a terminal
- Edit the code from the `parent` directory, gradually transforming it into a modular application
  following the points above (the result is in `modules` directory)
- Run application and tests from the IDE
- Build project with Maven
- Run application from the command line
- Run `jlink` to create a custom runtime
- Build and run a docker container
- Go back to the final summary slide
- Q/A

# Links

- JPMS specifications
    - https://openjdk.org/projects/jigsaw/spec/
- Understanding Java Modules
    - https://www.oracle.com/corporate/features/understanding-java-9-modules.html
- Loading classes and resources
    - https://stackoverflow.com/questions/45166757/loading-classes-and-resources-in-java-9

# Toolbox

    > java -p application/target/application-1.0-SNAPSHOT-dir --list-modules

    > java -p application/target/application-1.0-SNAPSHOT-dir -m org.example.application

    > jlink --module-path application/target/application-1.0-SNAPSHOT-dir \
    --add-modules org.example.application --output target/app

    > du -sh target/app

    > target/app/bin/java -m org.example.application

# TODOs

- Research modules support in popular tools and frameworks such as Gradle, Spring Boot, Wildfly,
  etc
- Consider mentioning `moditest`: https://github.com/moditect/moditect