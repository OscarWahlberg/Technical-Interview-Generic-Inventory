package se.tritech.javatest;

public interface Condition<T> {
    boolean evaluate(T object);
}