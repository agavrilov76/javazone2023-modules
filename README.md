# Practical experience of using Java Modules

20 min

# Abstract

Java Modules is one of the most prominent Java platform features. It appeared in Java 9 and since
have been slowly adopted by the Java developers. In this talk I want to share my experience in
building and running modular applications.

Starting with Java Modules is as simple as adding a module-info.java file to the source path. The
modern IDEs and build tools will automatically recognize it and help out to get started. Only
classes from the required modules will be visible for the application at the compile time. Only
specific modules can access the application classes via reflection at the runtime.

What is the difference between class-path and module-path? Do you need to declare module info for
tests? How does resource loading work across different modules? How to package and containerize the
modular application? Join, if you want to know!

# Topics

- Brief history of Java Modules
- The state of JPMS (platform) and modular applications. Why bother?
- Consider a sample Java project consisted of an application and a library. The app can read
  resources and parse JSON
- Add a module-info file: set the module name, add 'requires' and 'exports' sections
- Discuss readability and visibility
- Fix the package split issue with library code
- Open reflection module access to Jackson
- Add 'uses' to get the custom Jackson module to be visible
- Fix the resource loading issue
- Discuss the difference between encapsulated and not encapsulated resources
- Run tests and note the difference between module-path and class-path
- Build bundle with maven assembly plugin, show how to run the app with module path
- Create an executable distribution with jlink
- Create a Docker container and run it