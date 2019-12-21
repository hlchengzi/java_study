package com.java.java_study.java8.行为参数化;

/**
 * 行为参数化
 * @param <T>  将list抽象化
 */
public interface Predicate<T> {
    boolean test(T t);
}
