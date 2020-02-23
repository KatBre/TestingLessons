package org.kb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CesarToAhmedConverterTest {
//    @Test
//    public void convert_I_return1() {
//        CesarToAhmedConverter conv = new CesarToAhmedConverter();
//
//       int result =  conv.convert("I");
//
//        assertThat(result).isEqualTo(1);
//    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                arguments("I", 1),
                arguments("II", 2),
                arguments("IV", 4),
                arguments("V", 5),
                arguments("VII", 7),
                arguments("IX", 9),
                arguments("X", 10),
                arguments("XIV", 14),
                arguments("XV", 15),
                arguments("XX", 20),
                arguments("XXVI", 26),
                arguments("L", 50),
                arguments("LXXXVIII", 88),
                arguments("LXXXXVIII", 98),
                arguments("MMXLIX", 2049)

        );
    }

//    @ParameterizedTest
//    @MethodSource("inputProvider")
//    public void convert_singleCesarInput_returnAhmedNumber(String input, int expectedResult) {
//        CesarToAhmedConverter conv = new CesarToAhmedConverter();
//
//        int result =  conv.convert(input);
//
//        assertThat(result).isEqualTo(expectedResult);
//    }

}
