package org.superbiz.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(CalculatorApplication.class)
public class CalculatorApplicationTest {

    private CalculatorApplication calculatorApplication;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_add_two_numbers() {

        // given
        int a = 1;
        int b = 2;

        // when
        final String result = this.restTemplate.getForObject("/sum/{a}/{b}", String.class, a, b);


        // then
        assertThat(result).isEqualTo("1 + 2 = 3");
    }
}
