// Records are a simple way to create immutable classes in Java.
// This record automatically generates a constructor, getters (name(), salary(), area()), and toString() methods.
public record Employee(String name, int salary, String area) {};