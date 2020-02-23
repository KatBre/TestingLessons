package org.kb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {
    @Test
    public void calculate_1plus1_returns2() {
        StringCalculator calc = new StringCalculator();

        int result = calc.calculate("1+1");

        assertThat(result).isEqualTo(2);
    }

//    @Test
//    public void calculate_1plus2_returns3() {
//        StringCalculator calc = new StringCalculator();
//
//        int result = calc.calculate("1+2");
//
//        assertThat(result).isEqualTo(3);
//    }
//
//
//    @Test
//    public void calculate_2plus2_returns4() {
//        StringCalculator calc = new StringCalculator();
//
//        int result = calc.calculate("2+2");
//
//        assertThat(result).isEqualTo(4);
//    }
//
//    @Test
//    public void calculate_8plus9_returns17() {
//        StringCalculator calc = new StringCalculator();
//
//        int result = calc.calculate("8+9");
//
//        assertThat(result).isEqualTo(17);
//    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                arguments("1+1", 2),
                arguments("1+2", 3),
                arguments("2+2", 4),
                arguments("8+9", 17),
                arguments("4*5", 17),
                arguments("40+5", 17)
        );
    }


    @ParameterizedTest
    @MethodSource("argumentProvider")
    public void calculate_addingTwoSingleDigits_returns1CorrectResult(String input, int expectedResult) {
        StringCalculator calc = new StringCalculator();

        int result = calc.calculate(input);

        assertThat(result).isEqualTo(expectedResult);
    }



}
