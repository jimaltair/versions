package org.example.java16;

import java.util.stream.Stream;

public class NewInStreams16 {
    public static void main(String[] args) {
        // mapMulti - это альтернатива flatMap, который позволяет не создавать вложенный стрим, а пушить новые элементы
        Stream.of("hello", "world")
                .<Character>mapMulti((str, sink) -> {
                    for (char c : str.toCharArray()) {
                        sink.accept(c);
                    }
                })
                .forEach(System.out::println);

        Stream.of("hello", "world")
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .forEach(System.out::println);
    }
}
