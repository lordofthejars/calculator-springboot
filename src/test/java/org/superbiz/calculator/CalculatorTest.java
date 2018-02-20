package org.superbiz.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void should_add_two_numbers() {

        // given
        Calculator calculator = new Calculator();

        // when
        final int result = calculator.add(1, 3);

        // then
        assertThat(result).isEqualTo(4);

    }

    @Test
    public void should_multiply_two_numbers() {

        // given
        Calculator calculator = new Calculator();

        // when
        final int result = calculator.multiply(1, 3);

        // then
        assertThat(result).isEqualTo(0);

    }
}
