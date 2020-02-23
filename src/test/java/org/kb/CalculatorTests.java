package org.kb;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CalculatorTests {

    @Test
    public void add_addingMoreThan2Numbers_returnsCorrectResult() {
        // to będzie test „czarnej skrzynki”

        // arrange
        Calculator calculator = new Calculator(new Subcalculator());

        // act
        int result = calculator.add(2, 5, 7);

        // assert
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void add_addingMoreThan2Numbers_correctlyCallsSubcalculator() {
        // to będzie test „białej skrzynki”

        // arrange
        Subcalculator subcalculator = spy(Subcalculator.class);
        Calculator calculator = new Calculator(subcalculator);

        // act
        calculator.add(1, 2, 5);

        // assert
        verify(subcalculator, times(3)).add(anyInt(), anyInt());
        verify(subcalculator, times(1)).add(0, 1);
        verify(subcalculator, times(1)).add(1, 2);
        verify(subcalculator, times(1)).add(3, 5);
        verifyNoMoreInteractions(subcalculator);

    }
}