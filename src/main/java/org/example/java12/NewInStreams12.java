package org.example.java12;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewInStreams12 {
    public static void main(String[] args) {
        // Stream.teeing - позволяет в один проход пропустить стрим через два коллектора и потом объединить их результаты
        Collector<BigDecimal, ?, BigDecimal> averaging =
                Collectors.teeing(
                        // collector1
                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add),
                        // collector2
                        Collectors.counting(),
                        // merger
                        (sum, count) -> sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_EVEN)
                );
        BigDecimal average = Stream.of(BigDecimal.ONE, BigDecimal.TEN).collect(averaging);
        System.out.println(average);
    }
}
